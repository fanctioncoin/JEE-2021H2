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

    public boolean checkUser(String login, String password, Map<Integer,Person> maps) {
        boolean present = false;
        if (login != null && password != null) {
            List<Person> personList= personRepoInMemories.findAllMap(maps);
            present = personList.stream()
                    .filter(x -> x.getCredUser().getLogin().equals(login))
                    .filter(x -> x.getCredUser().getPassword().equals(password))
                    .limit(1)
                    .findFirst()
                    .isPresent();
        }
        return present;
    }
     public Person getPerson(String login, String password, Map<Integer,Person> maps){
         Person person;
         boolean present =checkUser(login, password, maps);
             if (present) {
                 List<Person> personList = personRepoInMemories.findAllMap(maps);
                 person = personList.stream()
                         .filter(x -> x.getCredUser().getLogin().equals(login))
                         .findFirst()
                         .orElse(null);
                 return (person);
             }
        return null;
     }
}
