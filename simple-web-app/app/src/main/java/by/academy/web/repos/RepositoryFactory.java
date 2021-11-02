package by.academy.web.repos;

import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
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

    public static  ARepository getEmployeeRepository(Person person) {
        switch (TYPE) {
            case POSTGRES:

                if(person instanceof Coach){
                    return CoachRepository.getInstance(datasource);
                }

                else if(person instanceof Student){
                    return StudentRepository.getInstance(datasource);
                }

                return PersonRepositoryPostgres.getInstance(datasource);
            case MEMORY:
            default:
                return PersonRepositoryInMemory.getInstance();
        }
    }
}
