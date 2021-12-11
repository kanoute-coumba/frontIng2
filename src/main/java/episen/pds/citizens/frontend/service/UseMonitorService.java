package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.*;
import episen.pds.citizens.frontend.repository.UseMonitorProxy;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class UseMonitorService {

    private UseMonitorProxy useMonitorProxy = new UseMonitorProxy();

    public Iterable<ConsumptionByBuilding> getConsumptionByBuilding() {
        return useMonitorProxy.getConsumptionByBuilding();
    }

    public Iterable<Room> getRooms() {
        return  useMonitorProxy.getRooms();
    }

    public Iterable<Equipment> getEquipmentByRoom(int id_room) {
        return useMonitorProxy.getEquipmentByRoom(id_room);
    }

    public Iterable<RoomConditions> getConditionsInRoom(int id) {
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
}
