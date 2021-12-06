package com.staravoyt.spring.core;

import com.staravoyt.spring.core.model.Book;
import com.staravoyt.spring.core.model.Shop;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXml {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ctx.registerShutdownHook();


        Shop shopIrish = ctx.getBean("shopIrish", Shop.class);
        shopIrish.printInfo();


// Для теста как работают Init и Destroy

        Book bookTest=ctx.getBean("romansBook",Book.class);
        System.out.println(bookTest.toString());

        Book bookTest1=ctx.getBean("humorBook",Book.class);
        System.out.println(bookTest1.toString());

    }
}
