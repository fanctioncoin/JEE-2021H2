package by.academy.web.app;

import by.academy.web.repos.PersonRepoInMemories;
import by.academy.web.service.CoachService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet(value = "/admin")
public class AdminController extends Dispatcher {
    private final PersonRepoInMemories personRepoInMemories;
    {
        personRepoInMemories =new PersonRepoInMemories();
    }
    @Override
    public void init() throws ServletException {
        super.init();
    }
}
