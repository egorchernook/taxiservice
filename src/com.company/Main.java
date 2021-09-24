package com.company;

import people.*;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        System.out.println("test");
        for(String s : args){
            System.out.println("s=" + s);
        }

        Person person = new Person("Alex");
        System.out.println( person );

        User user = new User( "Ivan", "88005553535", 1);
        System.out.println( user );

        UserCollection userCollection = new UserCollection();
        userCollection.add( user );
        userCollection.add( ( new User("John", "89547286518", 2)));
        System.out.println( userCollection );
    }
}
