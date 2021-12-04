package order;

import сollectionsInterfaces.Addable;
import сollectionsInterfaces.Deletable;
import сollectionsInterfaces.Findable;
import сollectionsInterfaces.Iterable;

import java.util.*;

public class OrderCollection
        implements Addable<Order>,
        Deletable<Order>,
        Findable<Order>,
        Iterable<Order>
{
    private Map<Long, Order> orderMap = new HashMap<>();

    public OrderCollection() {
    }

    public OrderCollection(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public Iterator<Order> getCollectionIterator(){return orderMap.values().iterator();}

    @Override
    public void add(Order element) {
        orderMap.put( element.getId(), element );
    }

    @Override
    public void delete(Order element) {
        orderMap.remove( element.getId() );
    }

    public void clear(){
        orderMap.clear();
    }

    @Override
    public Order find(String pattern) {
        for ( Order a : orderMap.values() ){
            if (  (a.getId() != null ) && a.getId().toString().equals( pattern ) ){
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Order> findAll(String pattern) {
        Set<Order> ordersSet = new HashSet<>();
        for ( Order a : orderMap.values() ){
            if (   (a.getNumber() != null ) && a.getNumber().toString().equals( pattern )){
                ordersSet.add(a);
            }
        }
        return ordersSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCollection that = (OrderCollection) o;
        return Objects.equals(orderMap, that.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderMap);
    }

    @Override
    public String toString() {
        return "OrderCollection{" +
                "orderMap=" + orderMap +
                '}';
    }
}
