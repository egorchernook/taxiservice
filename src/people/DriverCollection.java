package people;

import controllers.*;
import java.util.*;

public class DriverCollection
        implements Addable<driver>,
        Deletable<driver>,
        Findable<driver> {
    private Map<Long, driver> DriverMap = new HashMap<>();

    public DriverCollection() {}
    public DriverCollection(Map<Long, driver>  DriverMap) {this.DriverMap = DriverMap;}

    public Iterator<driver> getUserCollectionIterator(){return DriverMap.values().iterator();}

    @Override
    public String toString() { return DriverMap.toString(); }

    @Override
    public void add(driver element) {
        DriverMap.put( element.getId(), element );
    }

    @Override
    public void delete(driver element) {
        DriverMap.remove( element.getId() );
    }

    @Override
    public driver find(String pattern) {
        for ( driver a : DriverMap.values() ){
            if (  (a.getName() != null ) && a.getName().equals(pattern)){
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<driver> findAll(String pattern) {
        return null;
    }

}
