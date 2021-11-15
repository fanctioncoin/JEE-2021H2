package by.academy.web.service;


import by.academy.web.model.Coach;
import by.academy.web.model.Person;
import by.academy.web.model.Student;
import by.academy.web.repos.Repository;
import by.academy.web.repos.RepositoryFactory;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return  studentList.stream()
                .filter(x->x.getBand().getName().equals(name))
                .collect(Collectors.toList());
    }
}
