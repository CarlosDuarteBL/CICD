// Carlos Duarte 1ITF6 r0841640
package fact.it.projectthemepark.model;

public class Person {
    private String firstName, surName;


    public Person() {
    }


    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @java.lang.Override
    public String toString() {
        return surName.toUpperCase() + " " + firstName;
    }
}


