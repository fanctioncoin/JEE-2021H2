package by.academy.web.service;

import by.academy.web.model.Admin;
import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.Repository;
import by.academy.web.repos.RepositoryFactory;

import java.util.Arrays;
import java.util.List;

public class LoginService {

    private final Repository repositoryAdmin = RepositoryFactory.getEmployeeRepository(new Admin());
    private final Repository repositoryCoach = RepositoryFactory.getEmployeeRepository(new Coach());
    private final Repository repositoryStudent = RepositoryFactory.getEmployeeRepository(new Student());

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

     public Person getPerson(String login, String password){
         Person person;
         List<Person> personList = repositoryAdmin.findAll();
         List<Person> personList1 = repositoryCoach.findAll();
         List<Person> personList2 = repositoryStudent.findAll();
         List<List<Person> > personOther = Arrays.asList(personList,personList1,personList2);

               for(List<Person> list: personOther){
                   boolean present =checkUser(login, password, list);
                   if(present){
                       person = list.stream()
                               .filter(x -> x.getCredUser().getLogin().equals(login))
                               .findFirst()
                               .orElse(null);
                       return person;
                   }
               }
        return null;
     }
}
