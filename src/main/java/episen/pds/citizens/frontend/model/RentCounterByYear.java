package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class RentCounterByYear {

    int year;
    String name_building;
    int counter;
}
