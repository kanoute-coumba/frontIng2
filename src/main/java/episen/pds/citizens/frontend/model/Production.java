package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Production {
    private int id;
    private Timestamp timestamp;
    private double value;
    private int idCentral;
}
