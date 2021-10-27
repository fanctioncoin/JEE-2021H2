package by.academy.web.service;


import by.academy.web.model.Person;
import by.academy.web.model.Student;


import java.util.List;
import java.util.stream.Collectors;

public class StudentService {


    public List<Student> findAllStudents(List<Person> personList) {
        return personList.stream()
                .filter(element->element instanceof Student)
                .map(element->(Student)element)
                .collect(Collectors.toList());
    }
}
