package by.academy.web.app;


import by.academy.web.model.Person;
import by.academy.web.repos.*;
import by.academy.web.service.LoginService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@Slf4j
@WebServlet(value = "/login")
public class LoginController extends Dispatcher {

    private final ARepository aRepository =RepositoryFactory.getEmployeeRepository(null);
    private final LoginService loginService;

    {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password =req.getParameter("password");
        log.info("Пользователь ввел Login = {}, password = {}", login, password);
        Person person = loginService.getPerson(login, password, aRepository.findAll());

        if (person != null) {
            HttpSession session = req.getSession();
            session.setAttribute("login", person);
            log.info("Пользователь .. {}... успешно авторизован ", login);
            this.forward("/home", req, resp);
        } else {
            log.info("Пользователь .. {}... не авторизован ", login);
            this.forward("/index.jsp", req, resp);
        }
    }
}
