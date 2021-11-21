package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.model.Test;
import episen.pds.citizens.frontend.repository.EquipmentProxy;
import episen.pds.citizens.frontend.repository.TestProxy;
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

    public Iterable<EquipmentWithConsumption> getEquipmentWithConsumption() {
        return EquipmentProxy.getEquipmentWithConsumption();

    }
}
