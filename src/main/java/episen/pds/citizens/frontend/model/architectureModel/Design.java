package episen.pds.citizens.frontend.model.architectureModel;

import lombok.Data;

@Data
public class Design {

    private int idDesign;
    private String nameDesign;
    private int lengthOffice;
    private int widthOffice;
    private int lengthOpenSpace;
    private int widthOpenSpace;
    private int lengthMeetingRoom;
    private int widthMeetingRoom;
    private int lengthIndividualRoom;
    private int widthIndividualRoom;

}
