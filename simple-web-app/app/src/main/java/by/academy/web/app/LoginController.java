package by.academy.web.app;

import by.academy.web.model.Person;
import by.academy.web.repos.PersonRepoInMemories;
import by.academy.web.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



@WebServlet(value = "/login")
public class LoginController extends Dispatcher {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final PersonRepoInMemories personRepoInMemories;
    private final LoginService loginService;
    private  Map<Integer, Person> maps;

    {
        personRepoInMemories = new PersonRepoInMemories();
        loginService = new LoginService();
        maps = new HashMap<>();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        maps = personRepoInMemories.addCoachesAndStudents();
        ServletContext stx = getServletContext();
        stx.setAttribute("maps", maps);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password =req.getParameter("password");
        logger.info("Пользователь ввел Login = {}, password = {}", login, password);
        ServletContext stx1 = getServletContext();
        Map<Integer, Person> maps1 = (Map<Integer, Person>) stx1.getAttribute("maps");
        Person person = loginService.getPerson(login, password, maps1);
        if (person != null) {
            HttpSession session = req.getSession();
            session.setAttribute("login", person);
            logger.info("Пользователь .. {}... успешно авторизован ", login);
            this.forward("/home", req, resp);
        } else {
            logger.info("Пользователь .. {}... не авторизован ", login);
            this.forward("/index.jsp", req, resp);
        }
    }
}
