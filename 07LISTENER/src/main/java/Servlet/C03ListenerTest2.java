package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/session/remove","/session/attr/add","/session/attr/replace","/session/attr/remove"})
public class C03ListenerTest2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("[SERVLET] C03Listener Test service");
			String uri = req.getRequestURI();
			HttpSession session = req.getSession();
			
			if(uri.contains("/session/remove")) {
				//세션제거
				session.invalidate();				
			}else if(uri.contains("/session/attr/add")) {
				
			}else {
				
				
			}
	}
	
	
	
}
