package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
import episen.pds.citizens.frontend.model.Equipment;
import episen.pds.citizens.frontend.model.RoomsWithConsumption;
import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.repository.UseMonitorProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UseMonitorService {

    private UseMonitorProxy useMonitorProxy = new UseMonitorProxy();
    public Iterable<ConsumptionByBuilding> getConsumptionByBuilding() {
        return useMonitorProxy.getConsumptionByBuilding();
    }

    public Iterable<RoomsWithConsumption> getRooms() {
        return  useMonitorProxy.getRoomsWithConsumption();
    }

    public Iterable<Equipment> getEquipmentByRoom(int id_room) {
        return useMonitorProxy.getEquipmentByRoom(id_room);
    }
}
