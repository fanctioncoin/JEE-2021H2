package by.academy.web.service;

import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.repos.Repository;
import by.academy.web.repos.RepositoryFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class CoachService {

    private final Repository repository = RepositoryFactory.getEmployeeRepository(new Coach());


    /**
     * Для правильного подбора Id для Юзера, будем находить последний выданный
     * ID(т.е максимальный элемент ключа) и добавлять следующего
     *
     * @return
     */
    public int generateId(Map<Integer, Person> personMap) {
        List<Integer> listId = new ArrayList<>(personMap.keySet());
        int max = listId.stream()
                .reduce(Integer::max)
                .get();

        return max+1;
    }

    public BigDecimal average(List<Integer> integers) {
        double average = integers.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }

    public BigDecimal averageSalary(List<Coach> coaches) {
        List<Integer> salaries = coaches.stream()
                .map(Coach::getSalary)
                .collect(Collectors.toList());
        return average(salaries).setScale(2, RoundingMode.HALF_UP);
    }

    public List<Coach> filterCoachForMap(){
         return repository.findAll();
     }

}
