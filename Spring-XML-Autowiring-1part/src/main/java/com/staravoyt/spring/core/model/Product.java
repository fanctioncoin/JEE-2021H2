package com.staravoyt.spring.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    protected int id;
    protected String name;
    protected String description;
    protected int price;
}
