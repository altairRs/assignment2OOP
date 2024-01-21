import java.util.*;

class Person implements Comparable<Person> {
    private static int nextId = 1;
    private int id;
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
    }

    public String getPosition() {
        return "Student";
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }

    public double getPaymentAmount() {
        return 0.0;
    }

    public int getId() {
        return id;
    }
}