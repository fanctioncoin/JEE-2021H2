package by.academy.web.model;

import java.util.Objects;

public abstract class Person  {
    private CredUser credUser;
    private int id;
    private String name;
    private int age;
   //

   public Person() {
   }

    public Person(CredUser credUser, int id, String name, int age) {
        this.credUser = credUser;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public CredUser getCredUser() {
        return credUser;
    }

    public void setCredUser(CredUser credUser) {
        this.credUser = credUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(credUser, person.credUser) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credUser, id, name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
