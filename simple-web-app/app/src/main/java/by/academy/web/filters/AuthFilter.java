package by.academy.web.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/main/*","/student/*","/update-student/*","/user-coach/*","/admin-features/*","/add-coach","/update-coach","/delete-coach"})
public class AuthFilter extends AbstraсtFilter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        HttpSession session =req.getSession();
           if (session!=null && session.getAttribute("login")!=null) {
            filterChain.doFilter(req,resp);
        }  else {
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
    }
}
