package by.academy.web.repos;


import by.academy.web.model.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonRepository {

    Map<Integer, Person> findAllMap();

    List<Person> findAll();

    Optional<Person> find(int id);

    Person save(Person person);
    
    Optional<Person> remove(Person person);

}
