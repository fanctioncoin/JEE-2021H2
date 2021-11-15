package by.academy.web.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.util.Objects;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Person extends Entity  {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REMOVE})
    @JoinColumn(name = "id_usr")
    private CredUser credUser;
    private String name;
    private int age;

    public Person(Integer id, CredUser credUser, String name, int age) {
        super(id);
        this.credUser = credUser;
        this.name = name;
        this.age = age;
    }

    public Person(CredUser credUser, String name, int age) {
        this.credUser = credUser;
        this.name = name;
        this.age = age;
    }
    public Person(Integer id, String name, int age) {
        super(id);
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
