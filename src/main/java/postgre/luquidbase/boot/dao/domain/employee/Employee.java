package postgre.luquidbase.boot.dao.domain.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    public Employee() {
    }

    public Employee(long id,
                    String firstName,
                    String lastName,
                    String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    private Employee(Builder builder) {
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setCountry(builder.country);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Employee copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.firstName = copy.getFirstName();
        builder.lastName = copy.getLastName();
        builder.country = copy.getCountry();
        return builder;
    }


    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(country, employee.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, country);
    }

    public static final class Builder {
        private long id;
        private String firstName;
        private String lastName;
        private String country;

        private Builder() {
        }

        public Builder id(long val) {
            id = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
