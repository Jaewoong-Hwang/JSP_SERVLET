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

public class PermissionFilter implements Filter {
	
	// URL : Permission Value
	private Map<String, Integer> pageGradeMap = new HashMap();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
		String projectPath = filterConfig.getServletContext().getContextPath();
		/*
		 * /admin_main 필요한 권한값(3) - ROLE_ADMIN 
		 * /manager_main 필요한 권한값(2) - ROLE_MANAGER
		 * /user_main 필요한 권한값(1)-ROLE_USER 권한없음(0) - ROLE_ANONYMOUS
		 */
		
		pageGradeMap.put(projectPath+"/admin_main",3);
		pageGradeMap.put(projectPath+"/manager_main",2);
		pageGradeMap.put(projectPath+"/user_main",1);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("FILTER : Perm Filter start...");
		chain.doFilter(req, resp);
		System.out.println("FILTER : Perm Filter end...");

	}

}
