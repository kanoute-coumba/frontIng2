package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.Room;
import episen.pds.citizens.frontend.model.RoomConditions;
import episen.pds.citizens.frontend.model.EquipmentAndData;
import episen.pds.citizens.frontend.repository.UseMonitorProxy;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class UseMonitorService {

    private UseMonitorProxy useMonitorProxy = new UseMonitorProxy();

    public Iterable<ConsumptionByBuilding> getConsumptionByBuilding() {
        return UseMonitorProxy.getConsumptionByBuilding();
    }

    public Iterable<Room> getRooms(int id_user) {
        return  useMonitorProxy.getRooms(id_user);
    }

    public Iterable<EquipmentAndData> getEquipmentByRoom(int id_room) {
        return useMonitorProxy.getEquipmentByRoom(id_room);
    }

    public RoomConditions getConditionsInRoom(int id) {
        return useMonitorProxy.getConditionsInRoom(id);
    }

    public Iterable<Equipment> getAllEquipments() {
        return useMonitorProxy.getAllEquipments();
    }

    public void setEquipmentValue(int id_equipment, double value) {
        useMonitorProxy.setEquipmentValue(id_equipment,value);
    }
    public void setEquipmentAuto(int id_equipment) {
        useMonitorProxy.setEquipmentAuto(id_equipment);
    }

    public void setEquipmentManu(int id_equipment) {
        useMonitorProxy.setEquipmentManu(id_equipment);
    }

    public void setEquipmentOff(int id_equipment) {
        useMonitorProxy.setEquipmentOff(id_equipment);
    }

    public void setEquipmentOn(int id_equipment) {
        useMonitorProxy.setEquipmentOn(id_equipment);
    }

    public RoomConditions getCurrentConditionsInRoom(int id_room) {
        return useMonitorProxy.getCurrentConditionsInRoom(id_room);
    }
}
