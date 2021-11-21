package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.util.Iterator;

@Data
public class Test {

    private int id;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String firstname;


}


