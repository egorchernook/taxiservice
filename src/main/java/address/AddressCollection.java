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
    private List<Address> addressList = new LinkedList<>();

    public AddressCollection() {}
    public AddressCollection(List<Address>  addressList) {this.addressList = addressList;}

    @Override
    public Iterator<Address> getCollectionIterator(){return addressList.iterator();}

    @Override
    public String toString() { return addressList.toString(); }

    @Override
    public void add(Address element) {
        addressList.add( element );
    }

    @Override
    public void delete(Address element) {
        addressList.remove( element );
    }

    public Address delete_back(){
        return addressList.remove( addressList.size() - 1);
    }

    public boolean isEmpty(){
        return addressList.isEmpty();
    }

    public int size(){
        return addressList.size();
    }

    public void clear(){
        addressList.clear();
    }

    @Override
    public Address find(String pattern) {
        for ( Address a : addressList ){
            if (  (a.getName() != null ) && a.getName().equals(pattern)){
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Address> findAll(String pattern) {
        Set<Address> addressesSet = new HashSet<>();
        for ( Address a : addressList ){
            if (  (a.getName() != null ) && a.getName().equals(pattern)){
                addressesSet.add(a);
            }
        }
        return addressesSet;
    }
}
