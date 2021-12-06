package com.staravoyt.spring.core.model;


import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {
    private String binding; // Attribute указывающий на переплет книги

    public Book(int id, String name, String description, int price, String binding) {
        super(id, name, description, price);
        this.binding = binding;
    }
    public void startMethod(){
        System.out.println("Сработал startMethod-очень важный метод для Book");
    }
    public void finishMethod(){
        System.out.println("Ура наконец-то мы отработали c Book.КОНЕЦ!!!");
    }

}
