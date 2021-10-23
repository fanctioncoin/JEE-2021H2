package by.academy.web.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person extends Entity  {

    private CredUser credUser;
    private String name;
    private int age;

    public Person(int id, CredUser credUser, String name, int age) {
        super(id);
        this.credUser = credUser;
        this.name = name;
        this.age = age;
    }

    @Override
    public Person withId(Integer id) {
        setId(id);
        return this;
    }
    public Person withCredUser(CredUser credUser) {
        setCredUser(credUser);
        return this;
    }
    public Person withName(String name) {
        setName(name);
        return this;
    }
    public Person withAge(Integer age) {
        setAge(age);
        return this;
    }
}
