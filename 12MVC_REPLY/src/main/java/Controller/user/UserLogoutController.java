package Controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Service.UserServiceImpl;

public class UserLogoutController implements SubController{

	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private UserServiceImpl userService;
	
	public UserLogoutController() throws Exception{
		userService = UserServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserLogoutController execute..");
		
		try {
			
			HttpSession session = req.getSession();
			Boolean isAuth = session.getAttribute("isAuth")!=null?(Boolean)session.getAttribute("isAuth"):null;
			String role = (String)session.getAttribute("role");
			String username = (String)session.getAttribute("username");
			
			if(isAuth==null || isAuth==false) {	
				req.setAttribute("message", "로그인된 상태가 아닙니다");
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				return ;
			}	
			boolean isOk =  isValid(isAuth,role,username);
			//서비스
			Map<String,Object> serviceResponse  = userService.logout(req.getSession());
			Boolean isLogout = (Boolean)serviceResponse.get("isLogout");
			
			HttpSession reSession = req.getSession(true);
			if(isLogout!=null&& isLogout==true) {
				reSession.setAttribute("message", "로그아웃 성공!");
			}else {
				reSession.setAttribute("message", "로그아웃 실패!");
			}
			
			resp.sendRedirect(req.getContextPath()+"/user/login");
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}
	private boolean isValid(Boolean isAuth , String role , String username) {
		if(isAuth==null || isAuth==false) {	
			return false;
		}
		return true;
	}
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
