package address;
import сollectionsInterfaces.Identifiable;

import java.util.*;

public class Address implements Identifiable {
    private static Long counter=0L;
    private Long id;
    private String name;

    public Address(){
        counter++;
        name=null;
        id = counter;
    }

    public Address(String name){
        counter++;
        this.name=name;
        id = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(name, address.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

