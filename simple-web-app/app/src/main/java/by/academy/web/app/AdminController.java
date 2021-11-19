package by.academy.web.app;

import by.academy.web.model.Band;
import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(value = "/admin")
public class AdminController extends Dispatcher {

    private final AdminService adminService =new AdminService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer,Person> coachMap = adminService.findAllMap(new Coach());
        Map<Integer,Person> studentMap = adminService.findAllMap(new Student());
        List<Band> listBand =adminService.findBand();
            HttpSession session = req.getSession();
            session.setAttribute("listBand",listBand);
            req.setAttribute("coachMap", coachMap);
            req.setAttribute("studentMap", studentMap);
            this.forward("/admin-features", req, resp);
    }

    }

