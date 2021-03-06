package episen.pds.citizens.frontend.model;

public class ChoiceAlgoForm {
    private int id_choice_algo;
    private String choice;
    private String pref1;
    private String pref2;
    private String pref3;
    private float prop1;
    private float prop2;
    private float prop3;

    public ChoiceAlgoForm(){

    }

    public ChoiceAlgoForm(int id, String choice, String pref1, String pref2, String pref3, float prop1, float prop2, float prop3) {
        this.id_choice_algo = id;
        this.choice = choice;
        this.pref1 = pref1;
        this.pref2 = pref2;
        this.pref3 = pref3;
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
    }


    public int getIdChoiceAlgo() {
        return id_choice_algo;
    }

    public void setIdChoiceAlgo(int id) {
        this.id_choice_algo = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getPref1() {
        return pref1;
    }

    public void setPref1(String pref1) {
        this.pref1 = pref1;
    }

    public String getPref2() {
        return pref2;
    }

    public void setPref2(String pref2) {
        this.pref2 = pref2;
    }

    public String getPref3() {
        return pref3;
    }

    public void setPref3(String pref3) {
        this.pref3 = pref3;
    }

    public float getProp1() {
        return prop1;
    }

    public void setProp1(float prop1) {
        this.prop1 = prop1;
    }

    public float getProp2() {
        return prop2;
    }

    public void setProp2(float prop2) {
        this.prop2 = prop2;
    }

    public float getProp3() {
        return prop3;
    }

    public void setProp3(float prop3) {
        this.prop3 = prop3;
    }

    @Override
    public String toString() {
        return "ChoixAlgoForm{" +
                "id_choice_algo=" + id_choice_algo +
                ", choice='" + choice + '\'' +
                ", pref1='" + pref1 + '\'' +
                ", pref2='" + pref2 + '\'' +
                ", pref3='" + pref3 + '\'' +
                ", prop1=" + prop1 +
                ", prop2=" + prop2 +
                ", prop3=" + prop3 +
                '}';
    }

}
