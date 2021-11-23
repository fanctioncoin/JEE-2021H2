package by.academy.web.repos.memory;

import by.academy.web.model.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class CoachRepo implements CoachRepoInMemory{

    private final Map<Integer, Coach> map = new ConcurrentHashMap<>();
    private static volatile CoachRepo instance;

    private CoachRepo() {
    }

    //singleton

    public static CoachRepo getInstance() {
        if (instance == null) {
            synchronized (CoachRepo.class) {
                if (instance == null) {
                    instance = new CoachRepo();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Coach> findAll() {
        if (map.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<Coach> find(int id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public Coach save(Coach coach) {
            return coach.getId() == null ? insert(coach) : update(coach);
        }

        private Coach update(Coach coach) {
            Integer id = coach.getId();
            map.put(id, coach);
            return coach;
        }

        private Coach insert(Coach coach) {
            int id = generateId();
                coach.setId(id);
                CredUser credUser = coach.getCredUser();
                credUser.withId(id);
            map.put(id, coach);
            return coach;
    }


        private int generateId() {
            int id;
            do {
                id = ThreadLocalRandom.current().nextInt(1, 1_000);
            } while (map.containsKey(id));
            return id;
        }

    @Override
    public Optional<Coach> remove(Coach coach) {
        return Optional.ofNullable(map.remove(coach.getId()));
    }


    {
        map.put(1,new Coach()
                .withId(1)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach1")
                                .withPassword("123")
                                .withRole("COACH"))
                .withName("Ivan Ivanov")
                .withAge(32)
                .withSalary(1000));

        map.put(2,new Coach()
                .withId(2)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach2")
                                .withPassword("123")
                                .withRole("COACH"))
                .withName("Fred Mike")
                .withAge(30)
                .withSalary(1900));

        map.put(3,new Coach()
                .withId(3)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach3")
                                .withPassword("123")
                                .withRole("COACH"))
                .withName("Joe Kolobok")
                .withAge(19)
                .withSalary(1500));

        map.put(4,new Coach()
                .withId(4)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach4")
                                .withPassword("123")
                                .withRole("COACH"))
                .withName("Frank Sidorov")
                .withAge(29)
                .withSalary(1800));

        map.put(5,new Coach()
                .withId(5)
                .withCredUser(
                        new CredUser()
                                .withLogin("coach5")
                                .withPassword("123")
                                .withRole("COACH"))
                .withName("Jhon Mel")
                .withAge(33)
                .withSalary(900));
    }
}

