package by.academy.web.filters;

import by.academy.web.model.Person;
import by.academy.web.model.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebFilter(urlPatterns = {"/update-student/*"})
public class AuthCoachFilter extends AbstraсtFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Person person = (Person) session.getAttribute("login");
        if (person.getCredUser().getRole() != null) {
            if (person.getCredUser().getRole().toUpperCase(Locale.ROOT).equals("ADMIN") || person.getCredUser().getRole().toUpperCase(Locale.ROOT).equals("COACH")) {
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/student");
            }
        }
    }
}
