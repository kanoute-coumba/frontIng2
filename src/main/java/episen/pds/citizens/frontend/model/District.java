package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class District {
    private int id;
    private String name;
    private double consumption;
    private double production;
}