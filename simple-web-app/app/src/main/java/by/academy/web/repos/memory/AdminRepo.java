package by.academy.web.repos.memory;

import by.academy.web.model.Admin;
import by.academy.web.model.Coach;
import by.academy.web.model.CredUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class AdminRepo implements AdminRepoInMemory {

    private final Map<Integer, Admin> map = new ConcurrentHashMap<>();
    private static volatile AdminRepo instance;

    private AdminRepo() {
    }

    //singleton

    public static AdminRepo getInstance() {
        if (instance == null) {
            synchronized (AdminRepo.class) {
                if (instance == null) {
                    instance = new AdminRepo();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Admin> findAll() {
        if (map.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<Admin> find(int id) {
        return Optional.ofNullable(map.get(id));
    }


    @Override
    public Admin save(Admin admin) {
        return admin.getId() == null ? insert(admin) : update(admin);
    }

    private Admin update(Admin admin) {
        Integer id = admin.getId();
        map.put(id, admin);
        return admin;
    }

    private Admin insert(Admin admin) {
        int id = generateId();
        admin.setId(id);
        CredUser credUser = admin.getCredUser();
        credUser.withId(id);
        map.put(id, admin);
        return admin;
    }


    private int generateId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 1_000);
        } while (map.containsKey(id));
        return id;
    }

    @Override
    public Optional<Admin> remove(Admin admin) {
        return Optional.ofNullable(map.remove(admin.getId()));
    }

    {
        map.put(1, new Admin()
                .withId(10)
                .withCredUser(
                        new CredUser()
                                .withLogin("admin")
                                .withPassword("123")
                                .withRole("ADMIN"))
                .withName("Dim Bafe")
                .withAge(18));
    }
}
