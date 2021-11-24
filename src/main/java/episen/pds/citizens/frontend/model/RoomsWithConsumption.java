package episen.pds.citizens.frontend.model;

import lombok.Data;
@Data
public class RoomsWithConsumption {
    private int id;
    private String building;
    private float consumption;
    private String name;
    private boolean presence;
}
