package streampeoplesorting.models;

import java.util.Objects;

public class Person {
    private final String lastname;
    private final String firstname;
    private final Byte age;

    public Person(String lastname, String firstname, Byte age) {
        this.lastname = lastname;
        this.firstname = firstname;
        this. age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return lastname + " " + firstname + " " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastname, person.lastname) && Objects.equals(firstname, person.firstname) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, age);
    }
}
