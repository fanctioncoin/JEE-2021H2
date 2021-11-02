package by.academy.web.model;


import lombok.AllArgsConstructor;



public class Admin extends Person {

    public Admin() {
    }

    public Admin(Integer id, CredUser credUser, String name, int age) {
        super(id, credUser, name, age);
    }
    @Override
    public Admin withId(Integer id) {
        setId(id);
        return this;
    }

    @Override
    public Admin withCredUser(CredUser credUser) {
        setCredUser(credUser);
        return this;
    }

    @Override
    public Admin withName(String name) {
        setName(name);
        return this;
    }

    @Override
    public Admin withAge(Integer age) {
        setAge(age);
        return this;
    }

}

