package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.util.Date;

@Data
public class OccupationRate {

    private int year;
    private String name_building;
    private int rate;

}
