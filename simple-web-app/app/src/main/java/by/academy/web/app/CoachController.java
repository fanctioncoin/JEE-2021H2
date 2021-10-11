package by.academy.web.app;

import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;
import by.academy.web.model.Person;
import by.academy.web.model.Role;
import by.academy.web.repos.PersonRepoInMemories;
import by.academy.web.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


//@WebServlet(value = "/user-coach")
public class CoachController extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger( LoginController.class);
private final   PersonRepoInMemories personRepoInMemories;
private final   CoachService coachService;
    Map<Integer, Person> mapsPerson;
   {
        personRepoInMemories =new PersonRepoInMemories();
        coachService =new CoachService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext stx = getServletContext();
        mapsPerson = (Map<Integer, Person>) stx.getAttribute("maps");
        List<Coach> coaches = coachService.filterCoachForMap(mapsPerson);
        BigDecimal bigDecimal = coachService.averageSalary(coaches);
        req.setAttribute("salary", bigDecimal);
        req.setAttribute("listCoaches", coaches);

            if (req.getParameter("salarylist") != null) { //проверка чтобы узнать куда пользователь нажал
            getServletContext().getRequestDispatcher("/salary-coach").forward(req, resp);
            } else {
            getServletContext().getRequestDispatcher("/show-coaches").forward(req, resp);
        }
    }
    /**
     * Реализация для добавления новых тренеров с помощью админа.
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String login = req.getParameter("login");
          String password =req.getParameter("password");
          String name = req.getParameter("name");
          int age = Integer.parseInt(req.getParameter("age"));
          int salary =Integer.parseInt(req.getParameter("salary"));
             mapsPerson=(Map<Integer, Person>)getServletContext().getAttribute("maps");
          int id =coachService.generateId(mapsPerson); // добавление Id отдадим на проверку и присвоение.
        Coach coach = new Coach(new CredUser(id,login,password, Role.COACH),id,name,age,salary);
             mapsPerson = personRepoInMemories.addPerson(coach,mapsPerson);
             logger.info("Новый пользователь логин -{}  password -{}  успешно добавлен",login,password);
        getServletContext().setAttribute("maps",mapsPerson);
        resp.sendRedirect(req.getContextPath()+"/user-coach");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
         mapsPerson = (Map<Integer, Person>) getServletContext().getAttribute("maps");
        Coach coach = (Coach) personRepoInMemories.findById(id, mapsPerson);
           coach.setName(req.getParameter("name"));
           coach.setAge(Integer.parseInt(req.getParameter("age")));
           coach.setSalary(Integer.parseInt(req.getParameter("salary")));
         mapsPerson= personRepoInMemories.updatePerson(coach, mapsPerson);
        logger.info("Обновленный пользователь id -{}    успешно обновлен",id);
        getServletContext().setAttribute("maps", mapsPerson);
        resp.sendRedirect(req.getContextPath() + "/user-coach");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        mapsPerson = (Map<Integer, Person>) getServletContext().getAttribute("maps");
        Person person= personRepoInMemories.findById(id,mapsPerson);
        mapsPerson =personRepoInMemories.deletePerson(person,mapsPerson);
        getServletContext().setAttribute("maps", mapsPerson);
        logger.info("Удаленный пользователь id -{}    успешно удален!",id);
        resp.sendRedirect(req.getContextPath()+"/user-coach");
    }
}


