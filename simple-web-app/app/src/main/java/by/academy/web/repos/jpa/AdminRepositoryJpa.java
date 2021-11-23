package by.academy.web.repos.jpa;


import by.academy.web.model.Admin;
import by.academy.web.model.Coach;
import by.academy.web.repos.AdminInterfaceRepository;
import by.academy.web.repos.CoachInterfaceRepository;

import javax.persistence.TypedQuery;

public class AdminRepositoryJpa extends AbstractRepositoryJpa<Admin> implements AdminInterfaceRepository{
    private static volatile AdminRepositoryJpa instance;

    private AdminRepositoryJpa() {
        //singleton
    }

    public static AdminRepositoryJpa getInstance() {
        if (instance == null) {
            synchronized (AdminRepositoryJpa.class) {
                if (instance == null) {
                    instance = new AdminRepositoryJpa();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Admin> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Admin ", Admin.class);
    }
}
