package by.academy.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private String group;

    private List<String> marks;

    {
        marks = new ArrayList<>();
    }

    public Student() {
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(int id, String name, int age, String group, List<String> marks) {
        super(id, name, age);
        this.group = group;
        this.marks = marks;
    }

    public Student(CredUser credUser, int id, String name, int age, String group, List<String> marks) {
        super(credUser, id, name, age);
        this.group = group;
        this.marks = marks;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


    public List<String> getMarks() {
        return marks;
    }

    public void setMarks(List<String> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +

                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group) && Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), group, marks);
    }
}
