package by.academy.web.app;


import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.PersonRepoInMemories;
import by.academy.web.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(value = "/student")
public class StudentController extends Dispatcher {
    private static final Logger logger = LoggerFactory.getLogger( LoginController.class);

   private final   StudentService studentService;
   private final PersonRepoInMemories personRepoInMemories;
    Map<Integer, Person> mapsPerson;
    {
        studentService =new StudentService();
        personRepoInMemories =new PersonRepoInMemories();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext stx = getServletContext();
        mapsPerson = (Map<Integer, Person>) stx.getAttribute("maps");
        List<Student> students = studentService.findAllStudents(mapsPerson);
        req.setAttribute("students",students);
        this.forward("/show-students", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        mapsPerson = (Map<Integer, Person>) getServletContext().getAttribute("maps");
        Student student =(Student) personRepoInMemories.findById(id, mapsPerson);
        String marks1= req.getParameter("marks1");
        String marks2= req.getParameter("marks2");
        String marks3= req.getParameter("marks3");
        String marks4= req.getParameter("marks4");
        List<String> marks = Arrays.asList(marks1,marks2,marks3,marks4);
        student.setMarks(marks);
        mapsPerson= personRepoInMemories.updatePerson(student, mapsPerson);
        logger.info("Пользователь студент/ под id .. {}... успешно изменил свои оценки №1-{} №2-{} №3-{} №4-{} ",id,marks1,marks2,marks3,marks4);
        getServletContext().setAttribute("maps", mapsPerson);
        doGet(req,resp);
    }
}
