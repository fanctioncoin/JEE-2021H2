import by.academy.web.model.*;
import by.academy.web.repos.PersonRepoInMemories;
import by.academy.web.service.CoachService;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CoachServiceTest {

    private PersonRepoInMemories personRepoInMemories;
    private CoachService coachService;
    private Map<Integer, Person> personMap;
    private List<Coach> actualCoaches;

    {
        coachService = new CoachService();
        personMap = new HashMap<>();
        personRepoInMemories = new PersonRepoInMemories();
        actualCoaches = new ArrayList<>();
    }

//    @Before
//    public void setUp() {
//        System.out.println("Code executes before each test method");
//        personMap = personRepoInMemories.addCoachesAndStudents(); //заполнили мапу предварительными данными где все есть, тренеры, студенты, админ
//    }
//
//    @Test
//    public void whenFilterCoachForMap() {
//        setUp();
//        actualCoaches.add(new Coach(new CredUser(1, "coach1", "123", Role.COACH), 1, "Ivan Ivanov", 32, 1000));
//        actualCoaches.add(new Coach(new CredUser(2, "coach2", "123", Role.COACH), 2, "Fred Mike", 30, 1900));
//        actualCoaches.add(new Coach(new CredUser(3, "coach3", "123", Role.COACH), 3, "Joe Kolobok", 19, 1500));
//        actualCoaches.add(new Coach(new CredUser(4, "coach4", "123", Role.COACH), 4, "Frank Sidorov", 29, 1800));
//        actualCoaches.add(new Coach(new CredUser(5, "coach5", "123", Role.COACH), 5, "Jhon Mel", 33, 900));
//        List<Coach> listCoaches = coachService.filterCoachForMap(personMap); //проверка возращает ли лист Coach
//        Assertions.assertEquals(listCoaches, actualCoaches, "Два списка абсолютно равны и они тренеры!");
//        afterMethod();
//    }

//    @Test
//    public void whenAverageSalary() {
//        setUp();
//        List<Integer> integerList = Arrays.asList(1000, 1900, 1500, 1800, 900);
//        List<Coach> listCoaches = coachService.filterCoachForMap(personMap);
//        double average = integerList.stream()
//                .mapToInt(i -> i)
//                .average()
//                .orElse(0.0);
//        BigDecimal result = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP);
//        BigDecimal actual = coachService.averageSalary(listCoaches);
//        System.out.println("Средняя зарплата integerList = " + result);
//        System.out.println("Средняя зарплата actual = " + actual);
//        Assertions.assertEquals(result, actual, "Тест успешен");
//    }


    @After
    public void afterMethod() {
        System.out.println("Code executes after each test method");
    }
}
