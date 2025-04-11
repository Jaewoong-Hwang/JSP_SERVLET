package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/request/remove","/request/attr/add","/request/attr/replace","/request/attr/remove"})
public class C05ListenerTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[SERVLET] C05ListenerTest service");
		String uri = req.getRequestURI();

		if(uri.contains("/request/remove")) {
			//새로운 요청시마다 처리됨
			;
		}else if(uri.contains("/request/attr/add")) {
			req.setAttribute("R_KEY", "R_VAL");
		}else if(uri.contains("/request/attr/replace")) {
			req.setAttribute("R_KEY", "R_VAL_2");;
		}else if(uri.contains("/request/attr/remove")) {
			req.removeAttribute("R_KEY");
		}
	}
}
