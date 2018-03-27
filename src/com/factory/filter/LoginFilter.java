package com.factory.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 过滤器（拦截器），查看用户是否登陆过，未登录禁止访问页面
 * @author wjx
 */

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws ServletException,IOException {
       HttpSession session=((HttpServletRequest)request).getSession();
       response.setCharacterEncoding("utf-8");
       HttpServletResponse httpServletResponse = (HttpServletResponse)response;
       if(session.getAttribute("admin")==null){
       PrintWriter out=response.getWriter();
       httpServletResponse.sendRedirect("/Factory/JSP/login.jsp");
       //out.print("<script type=text/javascript>alert('please login');window.location.href='/JSP/login.jsp';</script>");
       }else{
        filterChain.doFilter(request, response);
       }
    }

    public void destroy() {
    }

}
