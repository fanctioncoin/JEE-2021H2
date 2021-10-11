package by.academy.web.repos;

import by.academy.web.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonRepo {

    Map<Integer,Person> addPerson(Person person,Map<Integer, Person> personMap);

    Map<Integer,Person> deletePerson(Person person,Map<Integer, Person> personMap);

    Map<Integer,Person> updatePerson(Person person,Map<Integer, Person> personMap);

    List<Person> findAll();

    Person findById(int id,Map<Integer, Person> personMap);


}
