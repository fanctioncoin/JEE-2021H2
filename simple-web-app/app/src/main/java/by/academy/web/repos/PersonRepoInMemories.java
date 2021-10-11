package by.academy.web.repos;

import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.model.Role;
import by.academy.web.model.Admin;
import com.sun.net.httpserver.HttpContext;

import javax.servlet.http.HttpSession;
import java.util.*;

public class PersonRepoInMemories implements PersonRepo{
    private static Map<Integer, Person> personMap;
    private static List<String> grades;


    {   personMap =new HashMap<>();
        grades =new ArrayList<String>();
    }


    @Override
    public Map<Integer, Person> addPerson(Person person,Map<Integer, Person> maps) {
         maps.put(person.getId(), person);
         return maps;
    }

    @Override
    public Map<Integer, Person> deletePerson(Person person,Map<Integer, Person> maps) {
         maps.remove(person.getId(),person);
         return maps;
    }

    @Override
    public Map<Integer, Person> updatePerson(Person person,Map<Integer, Person> maps) {
        maps.put(person.getId(), person);
        return maps;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<Person>(personMap.values());
    }

    @Override
    public Person findById(int id,Map<Integer, Person> maps) {
        return maps.get(id);
    }

    /**
     * Ниже хардкор методы откуда берутся обычные юзеры для примера
     */

    public void addGradeList() {
        grades= Arrays.asList("-","8","-","10");
    }

    public Map<Integer, Person>  addCoachesAndStudents(){
        addGradeList();
        personMap.put(1,new Coach(new CredUser(1,"coach1","123", Role.COACH),1,"Ivan Ivanov",32,1000));
        personMap.put(2,new Coach(new CredUser(2,"coach2","123", Role.COACH),2,"Fred Mike",30,1900));
        personMap.put(3,new Coach(new CredUser(3,"coach3","123", Role.COACH),3,"Joe Kolobok",19,1500));
        personMap.put(4,new Coach(new CredUser(4,"coach4","123", Role.COACH),4,"Frank Sidorov",29,1800));
        personMap.put(5,new Coach(new CredUser(5,"coach5","123", Role.COACH),5,"Jhon Mel",33,900));
        personMap.put(6,new Student(new CredUser(6,"student6","123", Role.USER),6,"Vanya Petrov", 20,"GR-1",grades));
        personMap.put(7,new Student(new CredUser(7,"student7","123", Role.USER),7,"Nic Tinov", 22,"GR-1",grades));
        personMap.put(8,new Student(new CredUser(8,"student8","123", Role.USER),8,"Alex Wapir", 23,"GR-2",grades));
        personMap.put(9,new Student(new CredUser(9,"student9","123", Role.USER),9,"Dima Bagenov", 24,"GR-2",grades));
        personMap.put(10, new Admin(new CredUser(10, "admin", "123", Role.ADMIN), 10, "Dimas Bagenovee", 28));
   return personMap;
    }
    public List<Person> findAllMap(Map<Integer, Person> maps) {
        return new ArrayList<Person>(maps.values());
    }
}
