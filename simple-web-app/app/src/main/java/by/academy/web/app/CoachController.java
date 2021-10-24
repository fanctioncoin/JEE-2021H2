package by.academy.web.app;

import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;
import by.academy.web.model.Person;
import by.academy.web.model.Role;
import by.academy.web.repos.PersonRepository;
import by.academy.web.repos.RepositoryFactory;
import by.academy.web.service.CoachService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


//@WebServlet(value = "/user-coach")
@Slf4j
public class CoachController extends HttpServlet {

    private final   CoachService coachService;
    private PersonRepository personRepository = RepositoryFactory.getEmployeeRepository();
    {
        coachService =new CoachService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Coach> coaches = coachService.filterCoachForMap(personRepository.findAll());
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
        Coach coach = new Coach(1,new CredUser(1,login,password, Role.COACH),name,age,salary);
             personRepository.save(coach);
             log.info("Новый пользователь логин -{}  password -{}  успешно добавлен",login,password);
        resp.sendRedirect(req.getContextPath()+"/user-coach");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<Person> person = personRepository.find(id);
        Coach coach = (Coach) person.orElse(null);
        if (coach!=null){
            coach.setName(req.getParameter("name"));
            coach.setAge(Integer.parseInt(req.getParameter("age")));
            coach.setSalary(Integer.parseInt(req.getParameter("salary")));
            personRepository.updatePerson(coach);
        }

        resp.sendRedirect(req.getContextPath() + "/user-coach");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<Person> person = personRepository.find(id);
        if (!person.isEmpty() && person != null) {
            personRepository.remove(person.orElse(null));
            log.info("Удаленный пользователь id -{}    успешно удален!", id);
        }
        resp.sendRedirect(req.getContextPath() + "/user-coach");
    }
}


