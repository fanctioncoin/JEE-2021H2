package by.academy.web.service;

import by.academy.web.model.Person;
import by.academy.web.repos.PersonRepoInMemories;
import java.util.List;
import java.util.Map;

public class LoginService {
private final PersonRepoInMemories personRepoInMemories;
    {
        personRepoInMemories =new PersonRepoInMemories();
    }

    public boolean checkUser(String login, String password, List<Person> personList) {
        boolean present = false;
        if (login != null && password != null) {
         //   List<Entity> personList= personRepoInMemories.findAllMap(maps);
            present = personList.stream()
                    .filter(x -> x.getCredUser().getLogin().equals(login))
                    .filter(x -> x.getCredUser().getPassword().equals(password))
                    .limit(1)
                    .findFirst()
                    .isPresent();
        }
        return present;
    }
     public Person getPerson(String login, String password, List<Person> personList){
         Person person;
         boolean present =checkUser(login, password, personList);
             if (present) {
//                 List<Entity> personList = personRepoInMemories.findAllMap(maps);

                 person = personList.stream()
                         .filter(x -> x.getCredUser().getLogin().equals(login))
                         .findFirst()
                         .orElse(null);
                 return person;
             }
        return null;
     }
}
