package people.users.driver;

import сollectionsInterfaces.*;
import сollectionsInterfaces.Iterable;

import java.util.*;


public class DriverCollection
        implements Addable<Driver>,
        Deletable<Driver>,
        Findable<Driver>,
        Iterable<Driver>
{
    private Map<Long, Driver> driverMap = new HashMap<>();

    public DriverCollection() {
    }

    public DriverCollection(Map < Long, Driver > DriverMap) {
        this.driverMap = DriverMap;
    }

    @Override
    public Iterator<Driver> getCollectionIterator() {
        return driverMap.values().iterator();
    }

    @Override
    public String toString () {
        return driverMap.toString();
    }

    @Override
    public void add (Driver element){
        driverMap.put(element.getId(), element);
    }

    @Override
    public void delete (Driver element){
        driverMap.remove(element.getId());
    }

    @Override
    public Driver find (String pattern) {
        for (Driver a : driverMap.values()) {
            if ((a.getName() != null) && a.getName().equals(pattern) ||
                    (a.getPassport() != null) && a.getPassport().equals(pattern) )  {
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Driver> findAll (String pattern){
        Set<Driver> driversSet = new HashSet<>();
        for (Driver a : driverMap.values()) {
            if ((a.getName() != null) && a.getName().equals(pattern) ||
                    (a.getPassport() != null) && a.getPassport().equals(pattern) ) {
                driversSet.add(a);
            }
        }
        return driversSet;
    }
}