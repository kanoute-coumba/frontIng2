package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Date;

@Data
public class PeakDay {

    Date date;
    Double consoday;
    Double value;
    int numberofpeak;

  }
