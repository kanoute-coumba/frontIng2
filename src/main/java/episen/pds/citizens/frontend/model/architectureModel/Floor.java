package episen.pds.citizens.frontend.model.architectureModel;

import lombok.Data;


@Data
public class Floor {
    private Integer id_floor;
    private String name_floor;
    private Integer id_building;
    private Integer id_design;

    public Floor() {}

    public Floor(Integer id_floor, String name_floor, Integer id_building, Integer id_design) {
        this.id_floor = id_floor;
        this.name_floor = name_floor;
        this.id_building = id_building;
        this.id_design = id_design;
    }
}

