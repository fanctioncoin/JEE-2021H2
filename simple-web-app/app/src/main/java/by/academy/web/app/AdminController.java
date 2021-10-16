package by.academy.web.app;

import by.academy.web.repos.PersonRepoInMemories;

import javax.servlet.annotation.WebServlet;


@WebServlet(value = "/admin")
public class AdminController extends Dispatcher {
    private final PersonRepoInMemories personRepoInMemories;
    {
        personRepoInMemories =new PersonRepoInMemories();
    }

}
