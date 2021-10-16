package people.users.client;

import order.OrderCollection;
import  people.users.User;

import java.util.Objects;

public class Client extends User {
    private String phoneNumber = null;
    private Integer rate = 500;
    private OrderCollection orderCollection = new OrderCollection();

    public Client(String phoneNumber) {
        super(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(rate, client.rate) && Objects.equals(orderCollection, client.orderCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, rate, orderCollection);
    }

    @Override
    public String toString() {
        return "Client{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", rate=" + rate +
                ", orderCollection=" + orderCollection +
                '}';
    }
}
