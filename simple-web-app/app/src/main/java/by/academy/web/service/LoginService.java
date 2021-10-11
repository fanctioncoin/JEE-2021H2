package by.academy.web.service;

import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;
import by.academy.web.model.Person;
import by.academy.web.repos.PersonRepoInMemories;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


public class LoginService {
private final PersonRepoInMemories personRepoInMemories;
    {
        personRepoInMemories =new PersonRepoInMemories();
    }

    public boolean checkUser(String login, String password, Map<Integer,Person> maps) {
        boolean present = false;
        if (login != null && password != null) {
            List<Person> personList= personRepoInMemories.findAllMap(maps);
          //  List<Person> personList = personRepoInMemories.findAll();
            present = personList.stream()
                    .filter(x -> x.getCredUser().getLogin().equals(login))
                    .filter(x -> x.getCredUser().getPassword().equals(password))
                    .limit(1)
                    .findFirst()
                    .isPresent();
        }
        return present;
    }
}
