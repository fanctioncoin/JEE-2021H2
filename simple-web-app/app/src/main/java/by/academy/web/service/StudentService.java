package by.academy.web.service;


import by.academy.web.model.Band;
import by.academy.web.model.CredUser;
import by.academy.web.model.Student;
import by.academy.web.repos.Repository;
import by.academy.web.repos.RepositoryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class StudentService {

    private final Repository repository = RepositoryFactory.getEmployeeRepository(new Student());


    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> find(int id) {
        return repository.find(id);
    }

    public void save(Student student) {
        repository.save(student);

    }

    public List<Student> studentsFilter(String name) {
        List<Student> studentList = repository.findAll();
        return studentList.stream()
                .filter(x -> x.getBand().getName().equals(name))
                .collect(Collectors.toList());
    }

    public Band findBand(String nameBand) {
        Band band;
        List<Student> studentList = repository.findAll();
        return band = studentList.stream()
                .map(Student::getBand)
                .distinct()
                .filter(x -> x.getName().equals(nameBand))
                .findFirst().orElse(null);
    }

    public Student createStudent(String login, String password, String name, int age, String nameBand) {
        Band band = findBand(nameBand);
        List<String> disciplines = band.getDisciplines();

        List<String> marks = new ArrayList<>();
        for (int i = 0; i < disciplines.size(); i++) {
            marks.add("-");
        }

        Student student = new Student()
                .withCredUser(
                        new CredUser()
                                .withLogin(login)
                                .withPassword(password)
                                .withRole("STUDENT"))
                .withName(name)
                .withAge(age)
                .withBand(
                        new Band()
                                .withId(band.getId())
                                .withName(band.getName())
                                .withCoach(band.getCoach())
                                .withDisciplines(band.getDisciplines()))
                .withMarks(marks);
        return student;
    }

    public boolean remove(int id) {
        Optional<Student> student = repository.find(id);
        if (!student.isEmpty() && student != null) {
            repository.remove(student.orElse(null));
            log.info("Удаленный пользователь id -{}    успешно удален!", id);
            return true;
        }
        return false;
    }

    public HttpServletRequest update(int id, HttpServletRequest req) {
        Optional<Student> student1 = repository.find(id);
        Student student = (Student) student1.orElse(null);
        if (student != null) {
            List<String> marks = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            String grades = "marks";

            for (int i = 1; i <= student.getBand().getDisciplines().size(); i++) {
                String result = grades + stringBuilder.append(i).toString();
                String res = req.getParameter(result);
                marks.add(res);
                stringBuilder.delete(0, stringBuilder.length());
            }
            student.setMarks(marks);
            save(student);
            log.info("Пользователь студент/ под id .. {}... успешно изменил свои оценки №1-{} №2-{} №3-{} №4-{} ", id);
        }
        return req;
    }
}
