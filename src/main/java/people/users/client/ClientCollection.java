package people.users.client;

import people.users.driver.Driver;
import сollectionsInterfaces.Addable;
import сollectionsInterfaces.Deletable;
import сollectionsInterfaces.Findable;
import сollectionsInterfaces.Iterable;

import java.util.*;

public class ClientCollection
        implements Addable<Client>,
        Deletable<Client>,
        Findable<Client>,
        Iterable<Client>
{
    private Map<Long, Client> clientMap = new HashMap<>();

    public ClientCollection() {
        this.test();
    }

    public ClientCollection(Map < Long, Client > DriverMap) {
        this.clientMap = DriverMap;
    }

    @Override
    public Iterator<Client> getCollectionIterator() {
        return clientMap.values().iterator();
    }

    @Override
    public void add(Client element) {
        clientMap.put(element.getId(), element);
    }

    @Override
    public void delete(Client element) {
        clientMap.remove(element.getId());
    }

    public void clear(){
        clientMap.clear();
    }

    @Override
    public Client find(String pattern) {
        for (Client a : clientMap.values()) {
            if ((a.getPhoneNumber() != null) && a.getPhoneNumber().equals(pattern) ) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Client> findAll(String pattern) {
        Set<Client> clientsSet = new HashSet<>();
        for (Client a : clientMap.values()) {
            if ((a.getPhoneNumber() != null) && a.getPhoneNumber().equals(pattern) ) {
                clientsSet.add(a);
            }
        }
        return clientsSet;
    }

    @Override
    public String toString() {
        return "ClientCollection{" +
                "clientMap=" + clientMap +
                '}';
    }

    private void test(){
        this.add( new Client( "Егор", "8888888888", "1".hashCode() ) );
        this.add( new Client( "Гоша", "7777777777", "1".hashCode() ) );
        this.add( new Client( "Мадина", "6666666666", "1".hashCode() ) );
        this.add( new Client( "Клава", "5555555555", "1".hashCode() ) );
    }
}
