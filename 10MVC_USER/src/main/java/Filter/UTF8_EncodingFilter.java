package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")	//url : /* 모든 url , *.do : 확장자가 do인 모든 요청
public class UTF8_EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("[Filter] UTF8_EncodingFilter..Start");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("[Filter] UTF8_EncodingFilter..End");
	
	}

}
