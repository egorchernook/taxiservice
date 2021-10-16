package controllers;

import order.Order;
import order.OrderCollection;

import java.util.Set;

public class OrderController {
    private OrderCollection orderCollection = new OrderCollection();

    public OrderController() {
    }

    public void add(Order address){
        orderCollection.add(address);
        }

    public void delete(Order address){
        orderCollection.delete(address);
        }

    public void clear(){
        orderCollection.clear();
        }

    public Order find(String pattern){
            return orderCollection.find(pattern);
        }

    public Set<Order> findAll(String pattern){
            return orderCollection.findAll(pattern);
        }

    @Override
    public String toString(){
            return orderCollection.toString();
        }

}
