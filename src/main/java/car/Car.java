package car;
import сollectionsInterfaces.Identifiable;

import java.util.*;

public class Car implements Identifiable {
    private static Long counter=0L;
    private Long id;
    private String number;
    private CarType carType;

    public Car(){
        counter++;
        number = null;
        carType = CarType.sedan;
        id = counter;
    }

    public Car(String number){
        counter++;
        this.number=number;
        id = counter;
    }

    public Car(String number, CarType TypeCar){
        counter++;
        this.number=number;
        this.carType = TypeCar;
        id = counter;
    }

    public CarType getCarType() {
        return carType;
    }
    public String getNumber() {
        return number;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id = " + id +
                ", number = '" + number +'\'' + ", TypeCar = '" + carType +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(number, car.number) && Objects.equals(carType, car.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, carType);
    }

}
