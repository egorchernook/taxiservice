package order;

import address.AddressCollection;
import сollectionsInterfaces.Identifiable;

import java.util.Date;
import java.util.Objects;

public class Order implements Identifiable{
    private static Long counter=0L;
    private Long id;
    private String number;
    private AddressCollection addressCollection = new AddressCollection();
    private Status status;
    private Integer feedback = 500;
    private Integer price;
    private Date orderDate = new Date();

    @Override
    public Long getId() {
        return id;
    }

    public Order() {
    }

    public Order(AddressCollection addressCollection, Integer price, Date orderDate) {
        this.id = counter;
        this.number = (counter++).toString();
        this.addressCollection = addressCollection;
        this.orderDate = orderDate;
        this.status = Status.booked;
        this.price = price;
    }
    public Order(AddressCollection addressCollection, Integer price) {
        this.number = (counter++).toString();
        this.addressCollection = addressCollection;
        this.status = Status.booked;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AddressCollection getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(AddressCollection addressCollection) {
        this.addressCollection = addressCollection;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getFeedback() {
        return feedback;
    }

    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(number, order.number)
                && Objects.equals(addressCollection, order.addressCollection)
                && status == order.status
                && Objects.equals(feedback, order.feedback)
                && Objects.equals(price, order.price)
                && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, addressCollection, status, feedback, price, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", addressCollection=" + addressCollection +
                ", status=" + status +
                ", feedback=" + feedback +
                ", price=" + price +
                ", orderDate=" + orderDate +
                '}';
    }
}
