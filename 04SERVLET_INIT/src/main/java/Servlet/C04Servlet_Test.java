package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join.do")
public class C04Servlet_Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do...");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /join.do...");
		//파라미터
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//입력값
		
		//작업처리 -> 세션에 담기!
		HttpSession session =  req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
			
		//뷰(/login.do redirect)
		resp.sendRedirect(req.getContextPath() +"/login.do");
		//05Servlet_test.java - GET /login.do 처리 서블릿
		//실제 login.jsp 는 /WEB-INF에서 생성하고 Forwarding 처리하기
		
	}
	
	
		
}
