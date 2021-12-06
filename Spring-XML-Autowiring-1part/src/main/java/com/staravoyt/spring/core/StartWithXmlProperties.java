package com.staravoyt.spring.core;


import com.staravoyt.spring.core.model.Shop;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXmlProperties {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
        ctx.registerShutdownHook();


        Shop shopIrish = ctx.getBean("shopIrish", Shop.class);
        shopIrish.printInfo();

    }
}
