package by.academy.web.model;


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

}
