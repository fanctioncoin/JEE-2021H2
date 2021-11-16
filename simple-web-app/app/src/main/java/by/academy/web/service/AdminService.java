package by.academy.web.service;

import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.Repository;
import by.academy.web.repos.RepositoryFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdminService {

    private final Repository repositoryCoach = RepositoryFactory.getEmployeeRepository(new Coach());
    private final Repository repositoryStudent = RepositoryFactory.getEmployeeRepository(new Student());


    public Map<Integer, Person> findAllMap(Person person) {
        if(person instanceof Coach){
            List<Coach> coachList = repositoryCoach.findAll();
            return coachList.stream()
                   .collect(Collectors.toMap(Person::getId, x->x));
        } else {
            List<Student> studentList = repositoryStudent.findAll();
            return studentList.stream()
                    .collect(Collectors.toMap(Person::getId, x->x));
        }
//        return map= Stream.concat(coachList.stream(), studentList.stream())
//                .collect(Collectors.toMap(Person::getId, x->x));
    }
}
