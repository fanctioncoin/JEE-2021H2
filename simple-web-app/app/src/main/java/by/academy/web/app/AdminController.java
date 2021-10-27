package by.academy.web.app;

import by.academy.web.model.Coach;
import by.academy.web.model.Student;
import by.academy.web.repos.PersonRepository;
import by.academy.web.repos.RepositoryFactory;
import by.academy.web.service.CoachService;
import by.academy.web.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/admin")
public class AdminController extends Dispatcher {

    private PersonRepository personRepository = RepositoryFactory.getEmployeeRepository();
    private final CoachService coachService =new CoachService();
    private final StudentService studentService =new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Coach> coaches = coachService.filterCoachForMap(personRepository.findAll());
        req.setAttribute("listCoaches", coaches);
        List<Student> students = studentService.findAllStudents(personRepository.findAll());
        req.setAttribute("students",students);
        this.forward("/admin-features", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
