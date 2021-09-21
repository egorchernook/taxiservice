package com.company;

import people.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("test");
        for(String s : args){
            System.out.println("s=" + s);
        }

        Person person = new Person("Alex");
        System.out.println(person);
    }
}
