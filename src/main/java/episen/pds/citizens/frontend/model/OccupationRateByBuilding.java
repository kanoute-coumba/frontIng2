package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class OccupationRateByBuilding {

    int year;
    String name_building;
    int rate;
}
