package by.academy.web.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "adm")
public class Admin extends Person {


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

