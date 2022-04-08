package episen.pds.citizens.frontend.model;

public class HistoricalProductionDate {
    private String mois;
    private int jour;

    public HistoricalProductionDate(){

    }
    public HistoricalProductionDate(String mois, int jour){
        this.mois = mois;
        this.jour = jour;
    }


    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    @Override
    public String toString() {
        return "HistoricalProductionDate{" +
                "mois='" + mois + '\'' +
                ", jour=" + jour +
                '}';
    }
}
