package by.academy.web.app;


import by.academy.web.model.Student;
import by.academy.web.service.StudentService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@WebServlet(value = "/student")
public class StudentController extends Dispatcher {

    private final StudentService studentService;

    {
        studentService = new StudentService();
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getParameter("name_band");
        List<Student> studentFilter = studentService.studentsFilter(name);
        if (name != null) {
            HttpSession session = req.getSession();
            if (name.equals("GLS_01_02")) {
                req.setAttribute("students", studentFilter);
                session.setAttribute("disciplines",studentFilter.get(0).getBand().getDisciplines());
                this.forward("/show-students", req, resp);

            } else if (name.equals("GLK_03_02")) {
                req.setAttribute("students", studentFilter);
                session.setAttribute("disciplines",studentFilter.get(0).getBand().getDisciplines());
                this.forward("/show-students", req, resp);
            }
        } else {
            this.forward("/show-band", req, resp);
        }
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Optional<Student> student1 = studentService.find(id);
        Student student = (Student) student1.orElse(null);
        if (student != null) {
            String marks1 = req.getParameter("marks1");
            String marks2 = req.getParameter("marks2");
            String marks3 = req.getParameter("marks3");
            String marks4 = req.getParameter("marks4");
            List<String> marks = Arrays.asList(marks1, marks2, marks3, marks4);
            student.setMarks(marks);
            studentService.save(student);
            log.info("Пользователь студент/ под id .. {}... успешно изменил свои оценки №1-{} №2-{} №3-{} №4-{} ", id, marks1, marks2, marks3, marks4);
        }
        doGet(req, resp);
    }
}
