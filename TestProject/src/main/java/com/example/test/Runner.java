package com.example.test;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Did I get you right?");
        System.out.println("Say it again, please");
        printSimpler("Some word");
    }
    static void printSimpler(String str){
        for (int i =0; i<5; i++){
            System.out.println(str);
        }
    }
}
