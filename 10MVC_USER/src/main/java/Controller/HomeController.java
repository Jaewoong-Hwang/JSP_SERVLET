package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
		}catch(Exception e) {
			exceptionHandler(e);
		}
			
	}
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
