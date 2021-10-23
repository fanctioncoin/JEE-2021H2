package by.academy.web.repos;

import by.academy.web.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class PersonRepositoryInMemory implements PersonRepository {

    private final Map<Integer, Person> map = new ConcurrentHashMap<>();

    private static volatile PersonRepositoryInMemory instance;

    private PersonRepositoryInMemory() {
        //singleton
    }

    public static PersonRepositoryInMemory getInstance() {
        if (instance == null) {
            synchronized (PersonRepositoryInMemory.class) {
                if (instance == null) {
                    instance = new PersonRepositoryInMemory();
                }
            }
        }
        return instance;
    }

    @Override
    public Map<Integer,Person>  findAllMap(){
        if (map.isEmpty()) {
            return new ConcurrentHashMap<>();
        }
        return map;
    }


    @Override
    public List<Person> findAll() {
        if (map.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<Person> find(int id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public Person save(Person person) {
        Integer id = person.getId();
        if(person.getId()==1){
            id = generateId();
            person.setId(id);
            CredUser credUser = person.getCredUser();
            credUser.withId(id);
        }
//        if (id == null && id ==1) {
//            id = generateId();
//            person.setId(id);
//        }
        map.put(id, person);
        return person;
    }

    private int generateId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 1_000);
        } while (map.containsKey(id));
        return id;
    }

    @Override
    public Optional<Person> remove(Person person) {
        return Optional.ofNullable(map.remove(person.getId()));
    }
    {
        List<String> grades= Arrays.asList("-","8","-","10");

        map.put(1,new Coach()
                .withId(1)
                .withCredUser(
                        new CredUser()
                        .withLogin("coach1")
                        .withPassword("123")
                        .withRole(Role.COACH))
                .withName("Ivan Ivanov")
                .withAge(32)
                .withSalary(1000));

        map.put(2,new Coach()
                .withId(2)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach2")
                                .withPassword("123")
                                .withRole(Role.COACH))
                .withName("Fred Mike")
                .withAge(30)
                .withSalary(1900));

        map.put(3,new Coach()
                .withId(3)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach3")
                                .withPassword("123")
                                .withRole(Role.COACH))
                .withName("Joe Kolobok")
                .withAge(19)
                .withSalary(1500));

        map.put(4,new Coach()
                .withId(4)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach4")
                                .withPassword("123")
                                .withRole(Role.COACH))
                .withName("Frank Sidorov")
                .withAge(29)
                .withSalary(1800));

        map.put(5,new Coach()
                .withId(5)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach5")
                                .withPassword("123")
                                .withRole(Role.COACH))
                .withName("Jhon Mel")
                .withAge(33)
                .withSalary(900));

        map.put(6,new Student()
                .withId(6)
                .withCredUser(
                        new CredUser()
                                .withLogin("student6")
                                .withPassword("123")
                                .withRole(Role.USER))
                .withName("Vanya Petrov")
                .withAge(20)
                .withGroupName("GR-1")
                .withMarks(grades));

        map.put(7,new Student()
                .withId(7)
                .withCredUser(
                        new CredUser()
                                .withLogin("student7")
                                .withPassword("123")
                                .withRole(Role.USER))
                .withName("Nic Tinov")
                .withAge(23)
                .withGroupName("GR-1")
                .withMarks(grades));

        map.put(8,new Student()
                .withId(8)
                .withCredUser(
                        new CredUser()
                                .withLogin("student8")
                                .withPassword("123")
                                .withRole(Role.USER))
                .withName("Alex Wapir")
                .withAge(21)
                .withGroupName("GR-2")
                .withMarks(grades));

        map.put(9,new Student()
                .withId(9)
                .withCredUser(
                        new CredUser()
                                .withLogin("student9")
                                .withPassword("123")
                                .withRole(Role.USER))
                .withName("Dima Bagenov")
                .withAge(24)
                .withGroupName("GR-2")
                .withMarks(grades));

// The profile is Admin

        map.put(10,new Admin()
                .withId(10)
                .withCredUser(
                        new CredUser()
                                .withLogin("admin")
                                .withPassword("123")
                                .withRole(Role.ADMIN))
                .withName("Dim Bafe")
                .withAge(18));

    }

}
