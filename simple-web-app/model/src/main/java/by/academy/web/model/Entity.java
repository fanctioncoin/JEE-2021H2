package by.academy.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Entity {

    private int id;

    public Entity withId(Integer id) {
        setId(id);
        return this;
    }

}
