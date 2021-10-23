package by.academy.web.repos;

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

    public static PersonRepository getEmployeeRepository() {
        switch (TYPE) {
            case POSTGRES:
                return PersonRepositoryPostgres.getInstance(datasource);
            case MEMORY:
            default:
                return PersonRepositoryInMemory.getInstance();
        }
    }
}
