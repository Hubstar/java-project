package no.hiof.haakonka.obligOOP.model;

public class Role {
    protected String characterFirstName;
    protected String characterLastName;
    protected Person actor;

    @Override
    public String toString() {
        return "The role has " +
                "first name of character='" + characterFirstName + '\'' +
                ", last name of character='" + characterLastName + '\'' +
                ", actor=" + actor +
                '}';
    }
}