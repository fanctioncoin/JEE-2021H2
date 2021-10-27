package by.academy.web.service;

import by.academy.web.model.Person;

import java.util.List;

public class LoginService {


    public boolean checkUser(String login, String password, List<Person> personList) {
        boolean present = false;
        if (login != null && password != null) {
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
                 person = personList.stream()
                         .filter(x -> x.getCredUser().getLogin().equals(login))
                         .findFirst()
                         .orElse(null);
                 return person;
             }
        return null;
     }
}
