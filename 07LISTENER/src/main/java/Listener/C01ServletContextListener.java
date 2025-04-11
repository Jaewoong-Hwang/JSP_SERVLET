package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class C01ServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) { //처음 구동될 때 사용되어야 하는 것들이 있다면
		//
		System.out.println("[LISTENER]C01ServletContextListener..start");
	}

	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[LISTENER]C01ServletContextListener..end");
		
	}
	
	
	
	


		
}
