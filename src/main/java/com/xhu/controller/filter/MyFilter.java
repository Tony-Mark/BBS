package com.xhu.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-17 20:46
 * @Description: TODO
 * @Version: 1.0
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
	String NO_LOGIN = "您还没有登录";
	
	String[] includeUrls = new String[]{"/getSession","/reply","/bbs"};
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
		HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
		httpServletResponse.setContentType("text/html;charset=utf-8");
		HttpSession httpSession=httpServletRequest.getSession(false);
		String url=httpServletRequest.getRequestURI();
		boolean needFilter = isNeedFilter(url);
		
		//放行静态资源
		if(url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".jpg")||url.endsWith(".map")
				||url.endsWith(".gif")||url.endsWith(".png")||url.endsWith(".html")){
			filterChain.doFilter(servletRequest,servletResponse);
			return;
		}
		
		if(!needFilter){  //需要放行的请求
			filterChain.doFilter(servletRequest,servletResponse);
		}else{ //判断session是否为空，进行拦截返回到登录页
			if (httpSession != null&&httpSession.getAttribute("userName") != null){
				// 存在session则放行
				filterChain.doFilter(servletRequest, servletResponse);
			}else{
				// 重定向到登录页
				// httpServletResponse.sendRedirect("/page/login2.html");
				httpServletRequest.getRequestDispatcher("/page/login2.html").forward(httpServletRequest, httpServletResponse);
			}
			return;
		}
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	public boolean isNeedFilter(String url){
		for(String includeUrl:includeUrls){
			if(includeUrl.equals(url)){
				return true;
			}
		}
		return false;
	}
}
