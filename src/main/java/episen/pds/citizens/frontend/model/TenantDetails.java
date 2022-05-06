package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.util.Date;

@Data
public class TenantDetails {

    Date date;
    String name_company;
    String type_space;
    String name_floor;
    String name_building;
}
