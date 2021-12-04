package people.users;

import people.Person;

import java.util.Objects;

public class User extends Person {
    private String login;
    private Integer password;

    public User(){
        this.login = null;
        this.password = null;
    }

    public User(User other){
        super( other.getName() );
        this.login = other.getLogin();
        this.password = other.getPassword();
    }

    protected User(Long id, String name, String login, Integer password) {
        super(id, name);
        this.login = login;
        this.password = password;
    }

    public void copy(User other){
        this.setName( other.getName() );
        this.login = other.getLogin();
        this.password = other.getPassword();
    }

    public User(String login) {
        this.login = login;
        this.password = 1;
    }

    public User(String login, Integer password) {
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, Integer password) {
        super(name);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "User{" +
                "login='" + login + '\'' +
                ", password=" + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password);
    }
}
