package com.staravoyt.spring.core;

import com.staravoyt.spring.core.model.Minimarket;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithXmlPropertiesAutowiringQualifierCustom {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties-autowiring-qualifier-custom.xml");
        ctx.registerShutdownHook();


        Minimarket minimarket =ctx.getBean("minimarket", Minimarket.class);
        minimarket.printInfo();

    }
}
