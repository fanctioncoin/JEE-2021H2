package by.academy.web.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends Person {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_band")
    public Band band;


    @ElementCollection
    @CollectionTable(name = "marks", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "mark")
    private List<String> marks;

    {
        marks = new ArrayList<>();
    }

    public Student(Integer id, CredUser credUser, String name, int age, Band band, List<String> marks) {
        super(id, credUser, name, age);
        this.marks = marks;
    }

    public  Student(CredUser credUser, String name, int age, Band band, List<String> marks) {
    }


    @Override
    public Student withId(Integer id) {
        setId(id);
        return this;
    }

    @Override
    public Student withCredUser(CredUser credUser) {
        setCredUser(credUser);
        return this;
    }

    @Override
    public Student withName(String name) {
        setName(name);
        return this;
    }

    @Override
    public Student withAge(Integer age) {
        setAge(age);
        return this;
    }

    public Student withBand(Band band){
        setBand(band);
        return this;
    }

    public Student withMarks(List<String> marks){
        setMarks(marks);
        return this;
    }
}
