package by.academy.web.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person  {
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
    public String getInfo() {
        return toString();
    }
}
