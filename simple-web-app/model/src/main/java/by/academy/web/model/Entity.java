package by.academy.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Entity {

    private Integer id;

    public Entity withId(Integer id) {
        setId(id);
        return this;
    }

}
