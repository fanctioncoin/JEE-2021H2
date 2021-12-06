package com.staravoyt.spring.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
//"Эта модель создана для демонстрации autowiring by name, byType не хотелось менять старые модели"
public class Supermarket implements PrintData
{
    private int id;
    private String name;
    @Autowired
    @Qualifier(value = "romansBook-qualifier")
    private Book book;
//    private Book romansBook;




}
