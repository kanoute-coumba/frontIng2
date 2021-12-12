package episen.pds.citizens.frontend.model;

import lombok.Data;

@Data
public class ConsumptionByBuilding {
    private String address;
    private float consumption;
    private String timestamp;
}
