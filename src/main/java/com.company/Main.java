package com.company;

import people.*;
import address.*;
import people.users.User;
import people.users.UserCollection;

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

        System.out.println("\n");

        Address address = new Address("Mira 90");
        System.out.println( address );

        AddressCollection AddressCollection = new AddressCollection();
        AddressCollection.add( address );
        AddressCollection.add( ( new Address("Mira 110")));
        System.out.println( AddressCollection );
    }
}
