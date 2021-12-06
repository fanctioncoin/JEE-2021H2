package com.staravoyt.spring.core.model;

import com.staravoyt.spring.core.qualifiers.NewYorkTimesQualifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
//"Эта модель создана для демонстрации qualifier-custom не хотелось менять старые модели"
public class Minimarket implements PrintData
{
    private int id;
    private String name;
    @Autowired
    @NewYorkTimesQualifier
    private Newspaper newspaper;





}
