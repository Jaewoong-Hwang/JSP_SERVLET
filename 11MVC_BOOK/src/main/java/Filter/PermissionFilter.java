package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;

public class PermissionFilter implements Filter{
	
	//URL : Permission Value
	private Map<String,Role> pageGradeMap = new HashMap();
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
		String projectPath = filterConfig.getServletContext().getContextPath();
//		/admin_main 	필요한 권한값(3) - ROLE_ADMIN 
//		/manager_main 	필요한 권한값(2) - ROLE_MANAGER
//		/user_main 		필요한 권한값(1) - ROLE_USER
//				
		
		//basic
		pageGradeMap.put(projectPath+"/", Role.ROLE_ANONYMOUS); //0
		pageGradeMap.put(projectPath+"/index.do", Role.ROLE_ANONYMOUS); //0
		
		//user
		pageGradeMap.put(projectPath+"/user/create", Role.ROLE_ANONYMOUS); //0
		pageGradeMap.put(projectPath+"/user/login", Role.ROLE_ANONYMOUS); //0
		pageGradeMap.put(projectPath+"/user/logout", Role.ROLE_ANONYMOUS); //0

		//role
		pageGradeMap.put(projectPath+"/user/admin", Role.ROLE_ADMIN); //3
		pageGradeMap.put(projectPath+"/user/manager", Role.ROLE_MANAGER); //2
		pageGradeMap.put(projectPath+"/user/user", Role.ROLE_USER); //1
		
		//book
		pageGradeMap.put(projectPath+"/book/list", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/create", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/read", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/update", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/delete", Role.ROLE_ANONYMOUS);
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
	
		HttpSession session = request.getSession();
		
		String myRole = (String)session.getAttribute("role");
		
		String uri = request.getRequestURI();
		if(uri.contains("/resources")) {
			;
		}else {
			if(myRole==null) {
				session.setAttribute("role", "ROLE_ANONYMOUS");
				response.sendRedirect(request.getContextPath()+"/user/login?msg=not authenticated...");
				return ;
			}

			Role my=null;
			switch(myRole)
			{
				case "ROLE_USER":
					my = Role.ROLE_USER;		//1
					break;
				case "ROLE_MANAGER":
					my = Role.ROLE_MANAGER;		//2
					break;			
				case "ROLE_ADMIN":
					my = Role.ROLE_ADMIN;		//3
					break;
				default : 
					my = Role.ROLE_ANONYMOUS;	//0
					break;
			}
			
			//Page Role Value 꺼내기
			String requestUri = request.getRequestURI();	// /project/admin_main..
			Role pageRole =  pageGradeMap.get(requestUri);
			
			System.out.printf("URL : %s,MyRole : %d, PageRole : %d\n",requestUri,my.ordinal(),pageRole.ordinal());
			
			if(my.ordinal()<pageRole.ordinal()) {
				throw new ServletException("해당 권한으로는 접근이 불가능한 페이지입니다.");
			}
			
			System.out.println("[FILTER] Perm Filter start..");
			
		}
	
		
		chain.doFilter(req, resp);
		System.out.println("[FILTER] Perm Filter end..");
	}

}
