package postgre.luquidbase.boot.service.dto.employee;

import java.util.Objects;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    public EmployeeDto() {
    }

    private EmployeeDto(Builder builder) {
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setCountry(builder.country);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(EmployeeDto copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.firstName = copy.getFirstName();
        builder.lastName = copy.getLastName();
        builder.country = copy.getCountry();
        return builder;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, country);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String country;

        private Builder() {
        }

        public Builder id(Long val) {
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

        public EmployeeDto build() {
            return new EmployeeDto(this);
        }
    }
}
