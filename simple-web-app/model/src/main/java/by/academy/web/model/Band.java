package by.academy.web.model;

// Наша группа студентов

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString(callSuper = true,exclude = "students")
@EqualsAndHashCode(callSuper = true,exclude = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Band extends Entity {

    private String name;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "id_coach")
    private Coach coach;

    @OneToMany(mappedBy = "band", cascade =  {CascadeType.REFRESH,CascadeType.REMOVE})
    private Set<Student> students;

    @ElementCollection
    @CollectionTable(name = "discipline", joinColumns = @JoinColumn(name = "band_id"))
    @Column(name = "name")
    private List<String> disciplines;

    {
        students = new HashSet<>();
        disciplines = new ArrayList<>();
    }

    public Band(String name, Coach coach, List<String> disciplines) {
        this.name = name;
        this.coach = coach;
        this.disciplines = disciplines;
    }

    @Override
    public Band withId(Integer id) {
        setId(id);
        return this;
    }


    public Band withName(String name) {
        setName(name);
        return this;
    }

    public Band withCoach(Coach coach) {
        setCoach(coach);
        return this;
    }

    public Band withStudents(Set<Student> students) {
        setStudents(students);
        return this;
    }

    public Band withDisciplines(List<String> disciplines) {
        setDisciplines(disciplines);
        return this;
    }
}
