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
                // в сессию потому что нужна информация на других страничках jsp
                session.setAttribute("students", studentFilter);
                session.setAttribute("disciplines",studentFilter.get(0).getBand().getDisciplines());
                session.setAttribute("marks",studentFilter.get(0).getMarks());
                this.forward("/show-students", req, resp);

            } else if (name.equals("GLK_03_02")) {
                session.setAttribute("students", studentFilter);
                session.setAttribute("disciplines",studentFilter.get(0).getBand().getDisciplines());
                session.setAttribute("marks",studentFilter.get(0).getMarks());
                this.forward("/show-students", req, resp);
            }
        } else {
            this.forward("/show-band", req, resp);
        }
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String method= (String) req.getParameter("method");

        if(method!=null && method.equals("delete")){
            doDelete(req,resp);
        } else if(method!=null && method.equals("update") ) {
            doPut(req,resp);
        } else {
            String login = req.getParameter("login");
            String password =req.getParameter("password");
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String nameBand =req.getParameter("raz");
              Student student =studentService.createStudent(login, password, name, age, nameBand);
              studentService.save(student);
              log.info("Новый пользователь логин -{}  password -{}  успешно добавлен",login,password);
        }
        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
         req= studentService.update(id,req);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.remove(id);
        doGet(req, resp);
    }
}

