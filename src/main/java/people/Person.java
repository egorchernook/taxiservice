package people;
import сollectionsInterfaces.Identifiable;

import java.util.Objects;

public class Person {
    private Long id;
    private String name;

    protected Person(){
        this.id = -1L;
        this.name=null;
    }

    protected Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void copy( Person other){
        this.id = other.id;
        this.name = other.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
