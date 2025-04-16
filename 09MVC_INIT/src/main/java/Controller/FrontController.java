package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/")
public class FrontController extends HttpServlet {
	// 서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String, SubController> map = new HashMap();
	@Override
	public void init(ServletConfig config) throws ServletException {

		ServletContext context = config.getServletContext();
		try {
			// 기본
			map.put("/", new HomeController());
			map.put("/index.do", new HomeController());
			
			// 인증(/user/*) - 회원CRUD , 로그인 , 로그아웃
			
			// 도서(/book/*) - 도서CRUD
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("서브컨트롤러 등록오류");
		}

	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			System.out.println("[FC] service...");
			String endPoint = req.getServletPath(); // ProjectPath 제외 EndPoint만
			System.out.println("[FC] endpoint .." + endPoint);
			SubController controller = map.get(endPoint); // 요청사항을 처리할 SubController get
			controller.execute(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			exceptionHandler(e,req);
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
		}
	}
	// 예외처리함수
	public void exceptionHandler(Exception e,HttpServletRequest req) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
