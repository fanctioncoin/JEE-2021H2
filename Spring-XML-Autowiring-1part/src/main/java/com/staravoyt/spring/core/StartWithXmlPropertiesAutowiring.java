package com.staravoyt.spring.core;

import com.staravoyt.spring.core.model.Supermarket;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXmlPropertiesAutowiring {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties-autowiring.xml");
        ctx.registerShutdownHook();


//ByName
//        Supermarket supermarket =ctx.getBean("supermarket", Supermarket.class);
//        supermarket.printInfo();

//ByType
        Supermarket supermarket =ctx.getBean("supermarketOther", Supermarket.class);
        supermarket.printInfo();

    }
}
