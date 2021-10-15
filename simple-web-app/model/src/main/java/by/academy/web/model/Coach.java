package by.academy.web.model;


import java.util.Objects;

public class Coach extends Person{
    private int salary;

    public Coach() {
    }


    public Coach(CredUser credUser, int id, String name, int age, int salary) {
        super(credUser, id, name, age);
        this.salary = salary;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Coach{" +
                super.toString() +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coach coach = (Coach) o;
        return salary == coach.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }
}
