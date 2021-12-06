package com.staravoyt.spring.core;

import com.staravoyt.spring.core.model.Supermarket;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXmlPropertiesAutowiringQualifier {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties-autowiring-qualifier.xml");
        ctx.registerShutdownHook();


        Supermarket supermarket =ctx.getBean("supermarketOther", Supermarket.class);
        supermarket.printInfo();

    }
}
