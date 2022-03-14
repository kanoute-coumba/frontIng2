package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Date;

@Data
public class ConsoByDay {

    private Date date;
    private double consoday;

    public ConsoByDay() {

    }

    public ConsoByDay(Date date, int consoday) {
        this.date = date;
        this.consoday = consoday;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getConsoday() {
        return consoday;
    }

    public void setConsoday(int consoday) {
        this.consoday = consoday;
    }
}