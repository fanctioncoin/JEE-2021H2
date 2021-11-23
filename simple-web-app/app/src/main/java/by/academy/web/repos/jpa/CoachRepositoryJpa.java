package by.academy.web.repos.jpa;


import by.academy.web.model.Coach;
import by.academy.web.repos.CoachInterfaceRepository;

import javax.persistence.TypedQuery;

public class CoachRepositoryJpa extends AbstractRepositoryJpa<Coach> implements CoachInterfaceRepository {
    private static volatile CoachRepositoryJpa instance;

    private CoachRepositoryJpa() {
        //singleton
    }

    public static CoachRepositoryJpa getInstance() {
        if (instance == null) {
            synchronized (CoachRepositoryJpa.class) {
                if (instance == null) {
                    instance = new CoachRepositoryJpa();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Coach> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Coach ", Coach.class);
    }
}
