package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.CentralByProduction;
import episen.pds.citizens.frontend.model.EquipmentWithConsumption;
import episen.pds.citizens.frontend.repository.CentralProxy;
import episen.pds.citizens.frontend.repository.EquipmentProxy;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Data
@Service
public class EnergyService {
    private static final Logger logger = Logger.getLogger(EnergyService.class.getName());

    public Iterable<EquipmentWithConsumption> getEquipmentWithConsumption(int id_b) {
        logger.info("EnergyService getEquipment");
        return EquipmentProxy.getEquipmentWithConsumption(id_b);

    }
    public Iterable<CentralByProduction> getCentralWithProduction(int id_b) {
        logger.info("EnergyService getCentral");
        return CentralProxy.getCentralByProduction(id_b);

    }
}
