package by.academy.web.repos;

import by.academy.web.exceptions.DatabaseException;
import by.academy.web.model.Admin;
import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.jpa.AdminRepositoryJpa;
import by.academy.web.repos.jpa.CoachRepositoryJpa;
import by.academy.web.repos.jpa.StudentRepositoryJpa;
import by.academy.web.repos.memory.AdminRepo;
import by.academy.web.repos.memory.CoachRepo;
import by.academy.web.repos.memory.StudentRepo;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class RepositoryFactory {
    private static final RepositoryTypes TYPE;
    private static RepositoryDatasource datasource;

    static {
        Properties appProperties = new Properties();
        try {
            appProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new DatabaseException(e);
        }
        TYPE = RepositoryTypes.getTypeByStr(appProperties.getProperty("repository.type"));
        if (TYPE == RepositoryTypes.POSTGRES) {
            datasource = RepositoryDatasource.getInstance(
                    appProperties.getProperty("postgres.driver"),
                    appProperties.getProperty("postgres.url"),
                    appProperties.getProperty("postgres.user"),
                    appProperties.getProperty("postgres.password"));
        }
    }

    private RepositoryFactory() {
        //factory empty private
    }

    public static Repository getEmployeeRepository(Person person) {
        switch (TYPE) {
            case POSTGRES:
                return getRepositoryPostgres(person);
            case MEMORY:
                return getRepositoryInMemory(person);
            case JPA:
                return getRepositoryInJpa(person);
        }
        return null;
    }

    private static Repository getRepositoryInJpa(Person person) {

        if(person instanceof Admin){
            return AdminRepositoryJpa.getInstance();

        } else if(person instanceof Coach){
            return CoachRepositoryJpa.getInstance();

        } else if(person instanceof Student){
            return StudentRepositoryJpa.getInstance();
        }
        return null;
    }

    private static Repository getRepositoryInMemory(Person person) {

        if (person instanceof Admin) {
            return AdminRepo.getInstance();

        } else if (person instanceof Coach) {
            return CoachRepo.getInstance();

        } else if (person instanceof Student) {
            return StudentRepo.getInstance();
        }
        return null;
    }

    private static Repository getRepositoryPostgres(Person person) {

        if(person instanceof Admin){
            return AdminRepository.getInstance(datasource);

        } else if(person instanceof Coach){
            return CoachRepository.getInstance(datasource);

        } else if(person instanceof Student){
            return StudentRepository.getInstance(datasource);
        }
        return null;
    }
}
