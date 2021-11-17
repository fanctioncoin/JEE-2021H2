package com.example.test.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(exclude = "cars")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "car_type")
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "carType", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Car> cars;
}
