package controllers;

import address.*;

import java.util.Set;

public class AddressController {
    private AddressCollection addressCollection = new AddressCollection();

    public AddressController() {
    }

    public void add(Address address){
        addressCollection.add(address);
    }

    public void delete(Address address){
        addressCollection.delete(address);
    }

    public void clear(){
        addressCollection.clear();
    }

    public Address find(String pattern){
        return addressCollection.find(pattern);
    }

    public Set<Address> findAll(String pattern){
        return addressCollection.findAll(pattern);
    }

    @Override
    public String toString(){
        return addressCollection.toString();
    }
}
