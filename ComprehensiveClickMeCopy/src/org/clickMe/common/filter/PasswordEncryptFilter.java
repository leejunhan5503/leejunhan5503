package org.clickMe.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.clickMe.common.wrapper.EncryptRequestWrapper;

/* memberService일 경우에만 비번 암호화 처리 */
@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
	
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		/* 로그인 요청은 필터에서 암호화되지 않도록 한다. */
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		System.out.println("uri : " + uri);
		
		String intent = uri.substring(uri.lastIndexOf("/"));
		System.out.println("intent : " + intent);
		
		/* 로그인 요청이 아닌 경우에만 암호화를 한다. */
		if(!"/login".equals(intent)) {
			
			EncryptRequestWrapper wrapper = new EncryptRequestWrapper(hrequest);
			
			chain.doFilter(wrapper, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {}
}
