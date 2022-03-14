package episen.pds.citizens.frontend.model.architectureModel;

import lombok.Data;


@Data
public class Building {

    private Integer id_building;
    private String address;
    private String name_building;
    private String type_building;
    private Integer id_owner;

    public Building() {}

    public Building(Integer id_building, String address, String name_building, String type_building) {
        this.id_building = id_building;
        this.address = address;
        this.name_building = name_building;
        this.type_building = type_building;
    }

}

