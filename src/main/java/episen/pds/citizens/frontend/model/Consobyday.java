package episen.pds.citizens.frontend.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Consobyday {

    private Date date;
    private int consoday;

    public Consobyday() {

    }

    public Consobyday(Date date, int consoday) {
        this.date = date;
        this.consoday = consoday;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getConsoday() {
        return consoday;
    }

    public void setConsoday(int consoday) {
        this.consoday = consoday;
    }
}