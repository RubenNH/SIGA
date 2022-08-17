package Siga.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;

@WebFilter(urlPatterns = {"/**"})
public class RequestFilter implements Filter{
    List<String>whitelist = new ArrayList<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whitelist.add("/");
        whitelist.add("/register-user");
        whitelist.add("/public-home");
        whitelist.add("/login");
        whitelist.add("/signin");
        whitelist.add("/recover-password");
        whitelist.add("/send-email");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String action = request.getServletPath();
        if(whitelist.contains(action)){
            chain.doFilter(servletRequest, servletResponse);
        }else {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null){
                chain.doFilter(servletRequest, servletResponse);
            }else {
                response.sendRedirect(request.getContextPath()+"(");
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}