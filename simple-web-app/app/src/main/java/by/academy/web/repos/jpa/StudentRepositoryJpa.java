package by.academy.web.repos.jpa;


import by.academy.web.model.Coach;
import by.academy.web.model.Student;
import by.academy.web.repos.StudentInterfaceRepository;

import javax.persistence.TypedQuery;

public class StudentRepositoryJpa extends AbstractRepositoryJpa<Student> implements StudentInterfaceRepository {
    private static volatile StudentRepositoryJpa instance;

    private StudentRepositoryJpa() {
        //singleton
    }

    public static StudentRepositoryJpa getInstance() {
        if (instance == null) {
            synchronized (StudentRepositoryJpa.class) {
                if (instance == null) {
                    instance = new StudentRepositoryJpa();
                }
            }
        }
        return instance;
    }


    @Override
    protected TypedQuery<Student> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Student ", Student.class);
    }
}
