package by.academy.web.repos;

import java.util.List;
import java.util.Optional;

public interface ARepository<T> {
    List<T> findAll();
    Optional<T> find(int id);
    T save(T person);
    Optional<T> remove(T person);
}
