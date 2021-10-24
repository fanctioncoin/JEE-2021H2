package by.academy.web.repos;

import by.academy.web.model.Person;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonRepositoryPostgres implements PersonRepository {
    private static volatile PersonRepositoryPostgres instance;
    private final DataSource dataSource;

    private PersonRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static PersonRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (PersonRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new PersonRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }


    @Override
    public Map<Integer, Person> findAllMap() {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Optional<Person> find(int id) {
        return Optional.empty();
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public Optional<Person> remove(Person person) {
        return Optional.empty();
    }
}
