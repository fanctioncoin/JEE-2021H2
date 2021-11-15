package by.academy.web.repos.memory;

import by.academy.web.model.*;
import by.academy.web.repos.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class StudentRepo implements StudentRepoInMemory{

    Repository repository = CoachRepo.getInstance();

    private final Map<Integer, Student> map = new ConcurrentHashMap<>();
    private static volatile StudentRepo instance;

    private StudentRepo() {
    }

    //singleton

    public static StudentRepo getInstance() {
        if (instance == null) {
            synchronized (StudentRepo.class) {
                if (instance == null) {
                    instance = new StudentRepo();
                }
            }
        }
        return instance;
    }


    @Override
    public List<Student> findAll() {
        if (map.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<Student> find(int id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public Student save(Student student) {
        return student.getId() == null ? insert(student) : update(student);
    }

    private Student update(Student student) {
        Integer id = student.getId();
        map.put(id, student);
        return student;
    }

    private Student insert(Student student) {
        int id = 0;
        if(student.getId()==null){
             id = generateId();
            student.setId(id);
            CredUser credUser = student.getCredUser();
            credUser.withId(id);
        }
        map.put(id, student);
        return student;
    }

    private int generateId() {
        int id;
        do {
            id = ThreadLocalRandom.current().nextInt(1, 1_000);
        } while (map.containsKey(id));
        return id;
    }

    @Override
    public Optional<Student> remove(Student person) {
        return Optional.empty();
    }

    {
        List<Coach> coachList = repository.findAll();
        List<String> grades= Arrays.asList("-","8","-","10");
        List<String> disciplines = addDiscipline();
        List<String> disciplines2 = addDiscipline2();
        map.put(6,new Student()
                .withId(6)
                .withCredUser(
                        new CredUser()
                                .withLogin("student6")
                                .withPassword("123")
                                .withRole("USER"))
                .withName("Vanya Petrov")
                .withAge(20)
                .withBand(
                        new Band()
                        .withName("GLS_01_02")
                        .withCoach(coachList.get(0))
                        .withDisciplines(disciplines))
                .withMarks(grades));

        map.put(7,new Student()
                .withId(7)
                .withCredUser(
                        new CredUser()
                                .withLogin("student7")
                                .withPassword("123")
                                .withRole("USER"))
                .withName("Nic Tinov")
                .withAge(23)
                .withBand(
                        new Band()
                                .withName("GLS_01_02")
                                .withCoach(coachList.get(0))
                                .withDisciplines(disciplines))
                .withMarks(grades));

        map.put(8,new Student()
                .withId(8)
                .withCredUser(
                        new CredUser()
                                .withLogin("student8")
                                .withPassword("123")
                                .withRole("USER"))
                .withName("Alex Wapir")
                .withAge(21)
                .withBand(
                        new Band()
                                .withName("GLK_03_02")
                                .withCoach(coachList.get(1))
                                .withDisciplines(disciplines2))
                .withMarks(grades));;

        map.put(9,new Student()
                .withId(9)
                .withCredUser(
                        new CredUser()
                                .withLogin("student9")
                                .withPassword("123")
                                .withRole("USER"))
                .withName("Dima Bagenov")
                .withAge(24)
                .withBand(
                        new Band()
                                .withName("GLK_03_02")
                                .withCoach(coachList.get(1))
                                .withDisciplines(disciplines2))
                .withMarks(grades));

    }

    private List<String> addDiscipline2() {
        List<String> discipline2 = new ArrayList<>();
        discipline2.add("Mechanic");
        discipline2.add("Management");
        discipline2.add("Control");
        discipline2.add("Algebra");

        return discipline2;
    }

    private List<String> addDiscipline() {
        List<String> discipline = new ArrayList<>();
        discipline.add("Logic");
        discipline.add("Biology");
        discipline.add("History");
        discipline.add("Algebra");

       return discipline;
    }

}
