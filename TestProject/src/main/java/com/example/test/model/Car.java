package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(exclude = "carType")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity

@NamedQueries({
        @NamedQuery(name = "byName", query = "select new com.example.test.dto.CarDto(c.name, c.speed, c.weight) from Car c where c.name = :name"),
        @NamedQuery(name = "bySpeed_200", query = "select new com.example.test.dto.CarDto(c.name, c.speed, c.weight) from Car c where c.speed >= :speed")
})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int speed;
    private int weight;

//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "car_type")
    private com.example.test.model.CarType carType;

    public Car(String name) {
        this.name = name;
    }
}
