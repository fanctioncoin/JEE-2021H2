package by.academy.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Discipline extends Entity {

    private String name;

    @Override
    public Discipline withId(Integer id) {
        setId(id);
        return this;
    }

    public Discipline withName(String name) {
        setName(name);
        return this;
    }
}
