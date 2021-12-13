package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.repository.EquipmentProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Data
@Service
public class EquipmentService {

    @Autowired
    private EquipmentProxy equipmentProxy = new EquipmentProxy();
    private static final Logger logger = Logger.getLogger(EquipmentService.class.getName());

    public Iterable<String> getListEquipment(Integer id_room, Integer id_floor) {
        return EquipmentProxy.getEquipment(id_room, id_floor);
    }

    public Iterable<Equipment> getEquipmentByRoom(Integer idr) {
        return EquipmentProxy.getEquipmentByRoom(idr);
    }

    public void updateStatutMode (String chooseStatut, String type_mode, Integer id_equipment) {
        System.out.println("debut");
        EquipmentProxy.updateStatutMode(chooseStatut, type_mode, id_equipment);
        logger.info("fin");
    }

    public void updateValueEquipment (Integer valueEquipment, Integer id_equipment) {
        System.out.println("début de nouvelle");
        EquipmentProxy.updateValueEquipment(valueEquipment, id_equipment);
        logger.info("fin 22");
    }

    public String getNameRoomByIdroom (Integer id_room) {
       return EquipmentProxy.getNameRoomByIdroom(id_room);
    }

    public String NameEquipment (Integer id_equipment) {
        System.out.println("deerrrrrr");
        System.out.println(EquipmentProxy.NameEquipment(id_equipment));
        return EquipmentProxy.NameEquipment(id_equipment);
    }

//
//
//    public void  UpdateTypeMode (String type_mode, Integer id_equipment) {
//        System.out.println("debut");
//        System.out.println(type_mode);
//        EquipmentProxy.updateStatutMode(type_mode, id_equipment);
//        System.out.println("milieux");
//        EquipmentProxy.UpdateTypeMode(type_mode, id_equipment);
//        System.out.println("fin");
//    }






//    public String equipmentLampe(Integer id_room, Integer id_equipment) {
//        return EquipmentProxy.getLampe(id_room, id_equipment);
//    }
//
//    public String equipmentClimatisation(Integer id_room, Integer id_equipment) {
//        return EquipmentProxy.getClimatisation(id_room, id_equipment);
//    }
//
//    public String equipmentRadiateur(Integer id_room, Integer id_equipment) {
//        return EquipmentProxy.getRadiateur(id_room, id_equipment);
//    }
//
//    public String equipmentFenetre(Integer id_room, Integer id_equipment) {
//        return EquipmentProxy.getFenetre(id_room, id_equipment);
//    }
//
//    public String equipmentStore(Integer id_room, Integer id_equipment) {
//        return EquipmentProxy.getStore(id_room, id_equipment);
//    }
//
//    public String equipmentScreen(Integer id_room, Integer id_equipment) {
//        return EquipmentProxy.getScreen(id_room, id_equipment);
//    }

//    public void updateStatutLampe(Equipment equipment, Integer id_room, Integer id_equipment) {
//        EquipmentProxy.updateStatutLampe(equipment, id_room, id_equipment);
//    }
}
