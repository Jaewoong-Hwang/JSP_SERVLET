package Listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class C06ServletRequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeAdded(srae);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeRemoved(srae);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeReplaced(srae);
	}
	
}
