package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class BuildingPatch {
    private int id;
    private String name;
    private String address;
    private String type;
    private String consumption;
    private String production;
}
