package people.users.driver;

import car.Car;
import order.OrderCollection;
import people.users.User;

import java.util.Objects;

public class Driver extends User {
    private Car car;
    private Integer rate = 500;
    private String passport;
    private OrderCollection orderCollection = new OrderCollection();

    public Driver(String name, String login, Integer password, Car car, String passport) {
        super(name, login, password);
        this.car = car;
        this.passport = passport;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public OrderCollection getOrderCollection() {
        return orderCollection;
    }

    public void setOrderCollection(OrderCollection orderCollection) {
        this.orderCollection = orderCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(car, driver.car)
                && Objects.equals(rate, driver.rate)
                && Objects.equals(passport, driver.passport)
                && Objects.equals(orderCollection, driver.orderCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, rate, passport, orderCollection);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car=" + car +
                ", rate=" + rate +
                ", passport='" + passport + '\'' +
                ", orderCollection=" + orderCollection +
                '}';
    }
}
