package people.users.operator;

import people.users.User;

import java.util.Objects;

public class Operator extends User {
    private String tabNumber;
    private String passport;

    public Operator(String tabNumber, String passport) {
        super(tabNumber);
        this.tabNumber = tabNumber;
        this.passport = passport;
    }

    public String getTabNumber() {
        return tabNumber;
    }

    public void setTabNumber(String tabNumber) {
        this.tabNumber = tabNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Operator operator = (Operator) o;
        return Objects.equals(tabNumber, operator.tabNumber) && Objects.equals(passport, operator.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tabNumber, passport);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "tabNumber='" + tabNumber + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
