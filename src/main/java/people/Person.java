package people;
import сollectionsInterfaces.Identifiable;

import java.util.Objects;

public class Person implements Identifiable {
    private static Long counter=0L;
    private Long id;
    private String name;

    public Person(){
        counter++;
        name=null;
        id = counter;
    }

    public Person(String name){
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
