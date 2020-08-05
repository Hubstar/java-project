package no.hiof.haakonka.obligOOP.model;

public class Person {
    protected String firstName;
    protected  String lastName;

    public String showFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person har fornavn " + firstName + '\'' +
                ", etternavn " + lastName + '\''
                ;
    }
}
