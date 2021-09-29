package people;

import controllers.*;
import java.util.*;

public class driver {
    private static Long counter=0L;
    private Long id;
    private String name;

    public driver(){
        counter++;
        name=null;
        id = counter;
    }

    public driver(String name){
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        driver Driver = (driver) o;
        return Objects.equals(id, Driver.id) && Objects.equals(name, Driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}


