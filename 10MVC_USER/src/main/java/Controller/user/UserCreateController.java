package Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

public class UserCreateController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private UserServiceImpl userService;
	
	public UserCreateController() throws Exception{
		userService = UserServiceImpl.getInstance();	
//		throw new Exception("TESTTSTST");
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserCreateController execute..");
		

		try {
			String uri = req.getMethod();
			if(uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
				return ;
			}
			
			//파라미터(username,password)
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String role = "ROLE_USER";
			//입력값검증
			UserDto userDto = new UserDto(username,password,role);
			boolean isOk = isValid(userDto);
			if(!isOk) {
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
				return ;
			}
			
			//서비스
			boolean isJoin =  userService.userJoin(userDto);
		
			//뷰
			if(isJoin) {
				resp.sendRedirect(req.getContextPath()+"/index.do");
			}else {
				req.getRequestDispatcher("/WEB-INF/view/user/join.jsp").forward(req, resp);
			}
			
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(UserDto userDto) {
		if (userDto.getUsername() == null || userDto.getUsername().length() <= 4) {
			req.setAttribute("username_err", "userid의 길이는 최소 5자이상이어야합니다");
			System.out.println("[INVALID] userid의 길이는 최소 5자이상이어야합니다");
			return false;
		}
		if (userDto.getUsername().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올수 없습니다");
			req.setAttribute("username_err", "userid의 userid의 첫문자로 숫자가 들어올수 없습니다");
			return false;
		}
		// NULL 체크 / 데이터(자료)수준에서의 의미있는데이터가 포함되어져있는지 여부
		// userid 은 첫문자가 숫자인지 여부 - /or 길이가 1글자인지 등등..
		// username 은 첫문자가 숫자인지 여부 -
		// password 복잡도체크는 Business Layer 체크(Policy 에 의한 처리)

		return true;
	}
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
