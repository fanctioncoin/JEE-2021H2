package com.staravoyt.spring.core.model;

import lombok.*;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Newspaper extends Product {

    private Map<String, Integer>  authorMap; // мапа для имя автора и количества публикаций

    public Newspaper(int id, String name, String description, int price, Map<String, Integer> authorMap) {
        super(id, name, description, price);
        this.authorMap = authorMap;
    }
}
