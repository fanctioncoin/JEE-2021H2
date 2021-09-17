package com.example.test;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Did I get you right?");
        System.out.println("Say it again, please");
        printWords("thanks");
        printSimpler("bag");
    }
    static void printSimpler(String str) {
        for (int i = 0; i < 2; i++) {
            System.out.println(str+"Slava");
        }
    }

        public static void printWords (String word){
            System.out.println(word);
        }
    }
