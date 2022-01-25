package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.House;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import episen.pds.citizens.frontend.repository.EquipmentProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Data
@Service
public class EquipmentService {

    @Autowired
    private EquipmentProxy equipmentProxy = new EquipmentProxy();
    private static final Logger logger = Logger.getLogger(EquipmentService.class.getName());

    public Iterable<Map<String, String>> getEquipmentByRoom(Integer idr) {
        return EquipmentProxy.getEquipmentByRoom(idr);
    }

    public void updateStatutMode(String chooseStatut, String type_mode, Integer id_equipment) {
        System.out.println("debut");
        EquipmentProxy.updateStatutMode(chooseStatut, type_mode, id_equipment);
        logger.info("fin");
    }

    public void updateValueEquipment(Integer valueEquipment, Integer id_equipment) {
        System.out.println("début de nouvelle");
        EquipmentProxy.updateValueEquipment(valueEquipment, id_equipment);
        logger.info("fin 22");
    }

    public String getNameRoomByIdroom(Integer id_room) {
        return EquipmentProxy.getNameRoomByIdroom(id_room);
    }

    public String NameEquipment(Integer id_equipment) {
        System.out.println("deerrrrrr");
        System.out.println(EquipmentProxy.NameEquipment(id_equipment));
        return EquipmentProxy.NameEquipment(id_equipment);
    }

    public Integer getIdRoomByEquipment(Integer id_equipment) {
        return EquipmentProxy.getIdRoomByEquipment(id_equipment);
    }

    public Iterable<Building> getBuildings(String email) {
        return EquipmentProxy.getBuildingsByUser(email);
    }



    public void updateStatutAuto(String type_mode, Integer id_equipment){
        EquipmentProxy.updateStatutAuto(type_mode, id_equipment);
        System.out.println(type_mode + "ttttp");
    }

}
