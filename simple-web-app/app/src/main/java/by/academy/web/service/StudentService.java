package by.academy.web.service;


import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.PersonRepoInMemories;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//
public class StudentService {

    private final PersonRepoInMemories personRepoInMemories;
    {
        personRepoInMemories =new PersonRepoInMemories();
    }

    public List<Student> findAllStudents(List<Person> personList) {
//        List<Person> personList = personRepoInMemories.findAllMap(mapsPerson);
        return personList.stream()
                .filter(element->element instanceof Student)
                .map(element->(Student)element)
                .collect(Collectors.toList());
    }
}
