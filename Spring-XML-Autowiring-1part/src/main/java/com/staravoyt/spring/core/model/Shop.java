package com.staravoyt.spring.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop implements PrintData
{
    private int id;
    private String name;
    private List<Book> books;
    private List<Magazine> magazines;
    private List<Newspaper> newspapers;



}
