package by.academy.web.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/main")
public class MainController extends Dispatcher {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("list") != null || req.getParameter("salarylist") != null) {
            this.forward("/user-coach", req, resp);
        } else if (req.getParameter("studentslist") != null) {
            this.forward("/student", req, resp);
        } else if (req.getParameter("adminFeatures") != null) {
            this.forward("/admin-features", req, resp);
        } else if (req.getParameter("exit") != null) {
            HttpSession httpSession = req.getSession();
            httpSession.removeAttribute("user");
            this.forward("/index.jsp", req, resp);
        }
    }
}


