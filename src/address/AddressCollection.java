package address;

import controllers.*;
import java.util.*;


public class AddressCollection
        implements Addable<Address>,
        Deletable<Address>,
        Findable<Address> {
    private Map<Long, Address> addressMap = new HashMap<>();

    public AddressCollection() {}
    public AddressCollection(Map<Long, Address>  addressMap) {this.addressMap = addressMap;}

    public Iterator<Address> getUserCollectionIterator(){return addressMap.values().iterator();}

    @Override
    public String toString() { return addressMap.toString(); }

    @Override
    public void add(Address element) {
        addressMap.put( element.getId(), element );
    }

    @Override
    public void delete(Address element) {
            addressMap.remove( element.getId() );
    }

    @Override
    public Address find(String pattern) {
        for ( Address a : addressMap.values() ){
            if (  (a.getName() != null ) && a.getName().equals(pattern)){
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Address> findAll(String pattern) {
        return null;
    }

}
