package episen.pds.citizens.frontend.model;

public class SimulationEconomicCost {
    private String conso;
    private String solaireAmort;
    private String eolienneAmort;
    private String hydrauliqueAmort;

    public SimulationEconomicCost(){}
    public SimulationEconomicCost(String conso, String solaireAmort, String eolienneAmort, String hydrauliqueAmort) {
        this.conso = conso;
        this.solaireAmort = solaireAmort;
        this.eolienneAmort = eolienneAmort;
        this.hydrauliqueAmort = hydrauliqueAmort;
    }


    public String getEolienneAmort() {
        return eolienneAmort;
    }

    public void setEolienneAmort(String eolienneAmort) {
        this.eolienneAmort = eolienneAmort;
    }
    public String getConso() {
        return conso;
    }

    public void setConso(String conso) {
        this.conso = conso;
    }

    public void setSolaireAmort(String solaireAmort) {
        this.solaireAmort = solaireAmort;
    }

    public String getSolaireAmort() {
        return solaireAmort;
    }

    public String getHydrauliqueAmort() {
        return hydrauliqueAmort;
    }

    public void setHydrauliqueAmort(String hydrauliqueAmort) {
        this.hydrauliqueAmort = hydrauliqueAmort;
    }
}
