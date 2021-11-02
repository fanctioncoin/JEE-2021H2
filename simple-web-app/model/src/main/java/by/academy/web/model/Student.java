package by.academy.web.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    private String groupName;

    private List<String> marks;

    {
        marks = new ArrayList<>();
    }

    public Student(Integer id, CredUser credUser, String name, int age, String groupName, List<String> marks) {
        super(id, credUser, name, age);
        this.groupName = groupName;
        this.marks = marks;
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

    public Student withGroupName(String groupName){
        setGroupName(groupName);
        return this;
    }

    public Student withMarks(List<String> marks){
        setMarks(marks);
        return this;
    }
}
