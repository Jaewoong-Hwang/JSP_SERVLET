package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/app/add","/app/replace","/app/remove"})
public class C02ListenerTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("[SERVLET] C02Listener Test service");
			String uri = req.getRequestURI();
			if(uri.contains("/app/add")) {
				req.getServletContext().setAttribute("CTX_KEY", "CTX_VLAUE");
				
			}else if(uri.contains("/app/relace")) {
				req.getServletContext().setAttribute("CTX_KEY", "CTX_VLAUE2");
			}else {
				
				req.getServletContext().removeAttribute("CTX_KEY");
			}
	}
	
	
	
}
