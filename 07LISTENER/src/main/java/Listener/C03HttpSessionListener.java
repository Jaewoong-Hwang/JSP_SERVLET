package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class C03HttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("[LISTENER] C03HttpSessionListener Created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("[LISTENER] C03HttpSessionListener Destroyed");
		
	}

}
