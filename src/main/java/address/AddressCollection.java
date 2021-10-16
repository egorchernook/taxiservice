package address;

import сollectionsInterfaces.*;
import сollectionsInterfaces.Iterable;

import java.util.*;

public class AddressCollection
        implements Addable<Address>,
        Deletable<Address>,
        Findable<Address>,
        Iterable<Address>
{
    private Map<Long, Address> addressMap = new HashMap<>();

    public AddressCollection() {}
    public AddressCollection(Map<Long, Address>  addressMap) {this.addressMap = addressMap;}

    @Override
    public Iterator<Address> getCollectionIterator(){return addressMap.values().iterator();}

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

    public void clear(){
        addressMap.clear();
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
        Set<Address> addressesSet = new HashSet<>();
        for ( Address a : addressMap.values() ){
            if (  (a.getName() != null ) && a.getName().equals(pattern)){
                addressesSet.add(a);
            }
        }
        return addressesSet;
    }
}
