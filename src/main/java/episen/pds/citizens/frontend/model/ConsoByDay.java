package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Date;

@Data
public class ConsoByDay {

    private Date date;
    private Double consoday;

    public ConsoByDay() {

    }

    public ConsoByDay(Date date, Double consoday) {
        this.date = date;
        this.consoday = consoday;
    }

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