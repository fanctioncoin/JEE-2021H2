package by.academy.web.app;


import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.ARepository;
import by.academy.web.repos.RepositoryFactory;
import by.academy.web.service.StudentService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Slf4j
@WebServlet(value = "/student")
public class StudentController extends Dispatcher {


    private final ARepository aRepository = RepositoryFactory.getEmployeeRepository(new Student());
    private final StudentService studentService;

    {
        studentService = new StudentService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.findAllStudents(aRepository.findAll());
        req.setAttribute("students", students);
        this.forward("/show-students", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Optional<Person> person = aRepository.find(id);
        Student student = (Student) person.orElse(null);
        if (student != null) {
            String marks1 = req.getParameter("marks1");
            String marks2 = req.getParameter("marks2");
            String marks3 = req.getParameter("marks3");
            String marks4 = req.getParameter("marks4");
            List<String> marks = Arrays.asList(marks1, marks2, marks3, marks4);
            student.setMarks(marks);
            aRepository.save(student);
            log.info("Пользователь студент/ под id .. {}... успешно изменил свои оценки №1-{} №2-{} №3-{} №4-{} ", id, marks1, marks2, marks3, marks4);
        }
        doGet(req, resp);
    }
}
