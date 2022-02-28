package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class BuildingPatch {
    private int id;
    private String name;
    private String address;
    private String type;
    private Double consumption;
    private Double production;
    private Integer district;
}
