package car;
import controllers.*;
import java.util.*;

public class Car {
    private static Long counter=0L;
    private Long id;
    private String number;
    private String TypeCar;

    public Car(){
        counter++;
        number=null;
        TypeCar=null;
        id = counter;
    }

    public Car(String number){
        counter++;
        this.number=number;
        id = counter;
    }

    public Car(String number, String TypeCar){
        counter++;
        this.number=number;
        this.TypeCar=TypeCar;
        id = counter;
    }

    public String getTypeCar() {
        return TypeCar;
    }
    public String getNumber() {
        return number;
    }
    public Long getId() {
        return id;
    }
    public void setTypeCar(String typeCar) {
        TypeCar = typeCar;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id = " + id +
                ", number = '" + number +'\'' + ", TypeCar = '" + TypeCar +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(number, car.number) && Objects.equals(TypeCar, car.TypeCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, TypeCar);
    }

}
