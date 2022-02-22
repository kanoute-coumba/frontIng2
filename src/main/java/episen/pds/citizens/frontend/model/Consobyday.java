package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Consobyday {

    private Date date;
    private Double consoday;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getConsoday() {
        return consoday;
    }

    public void setConsoday(Double consoday) {
        this.consoday = consoday;
    }
}