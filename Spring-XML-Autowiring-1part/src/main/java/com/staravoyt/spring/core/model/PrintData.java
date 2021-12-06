package com.staravoyt.spring.core.model;

public interface PrintData {
    default void printInfo() {
        System.out.println(this);
    }

    default void initTest() {
        System.out.println(this.getClass().getSimpleName() + " is initialised");
    }

    default void destroyTest() {
        System.out.println(this.getClass().getSimpleName() + " is destroyed");
    }
}

