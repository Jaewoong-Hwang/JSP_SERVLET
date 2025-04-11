package Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class C05ServletRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequestListener.super.requestDestroyed(sre);
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequestListener.super.requestInitialized(sre);
	}
	
}
