package episen.pds.citizens.frontend.service;

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

    public String equipmentLampe(Integer id_room, Integer id_equipment) {
        return EquipmentProxy.getLampe(id_room, id_equipment);
    }

    public String equipmentClimatisation(Integer id_room, Integer id_equipment) {
        return EquipmentProxy.getClimatisation(id_room, id_equipment);
    }
}
