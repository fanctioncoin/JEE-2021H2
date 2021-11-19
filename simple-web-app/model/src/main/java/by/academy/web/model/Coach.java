package by.academy.web.model;


import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@ToString(callSuper = true, exclude = "bands")
@EqualsAndHashCode(callSuper = true, exclude = "bands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coach extends Person{
    private int salary;

    // Частный случай когда один Тренер может быть у разных групп.
    @OneToMany(mappedBy = "coach", cascade = {CascadeType.MERGE})
    private Set<Band> bands =new LinkedHashSet<>();

    public Coach(Integer id, CredUser credUser, String name, int age, int salary) {
        super(id, credUser, name, age);
        this.salary = salary;
    }
    public Coach( Integer id, String name, int age, int salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public Coach(CredUser credUser, String name, int age, int salary) {
        super(credUser, name, age);
        this.salary = salary;
    }

    @Override
    public Coach withId(Integer id) {
        setId(id);
        return this;
    }

    @Override
    public Coach withCredUser(CredUser credUser) {
        setCredUser(credUser);
        return this;
    }

    @Override
    public Coach withName(String name) {
        setName(name);
        return this;
    }

    @Override
    public Coach withAge(Integer age) {
        setAge(age);
        return this;
    }

    public Coach withSalary(Integer salary) {
        setSalary(salary);
        return this;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    @Override
//    public String toString() {
//        return "Coach{" +
//                super.toString() +
//                ", salary=" + salary +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Coach coach = (Coach) o;
//        return salary == coach.salary;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), salary);
//    }
}
