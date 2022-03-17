package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class BuildingCentral {
    private Integer id;
    private String name;
    private String address;
    private String type;
    private Double maxCapacity;
    private Double capacity;
    private Double production;
}
