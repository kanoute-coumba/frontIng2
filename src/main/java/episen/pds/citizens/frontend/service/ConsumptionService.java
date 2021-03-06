package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.repository.ConsumptionProxy;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Data
@Service
public class ConsumptionService {
    private static final Logger logger = Logger.getLogger(ConsumptionService.class.getName());

    public Iterable<Consumption> getConsumptionByEquipment(int id_e){
        logger.info("getConsumptionByEquipment "+id_e);
        return ConsumptionProxy.getConsumptionByEquipment(id_e);
    }
    public Iterable<Consumption> getConsumptionByEquipmentBetweenTwoDate(int id_e, long db, long de){
        logger.info("getConsumptionByEquipment "+id_e +" Between "+db +" "+de);
        return ConsumptionProxy.getConsumptionByEquipmentBetweenTwoDate(id_e,db,de);
    }
    public ArrayList<Consumption> getConsumptionByRoomBetweenTwoDate(int id_r, long db, long de){
        logger.info("getConsumptionByEquipment "+id_r +" Between "+db +" "+de);
        return ConsumptionProxy.getConsumptionByRoomBetweenTwoDate(id_r,db,de);
    }
    public ArrayList<Consumption> getConsumptionByFloorBetweenTwoDate(int id_r, long db, long de){
        logger.info("getConsumptionByEquipment "+id_r +" Between "+db +" "+de);
        return ConsumptionProxy.getConsumptionByFloorBetweenTwoDate(id_r,db,de);
    }
    public ArrayList<Consumption> getConsumptionByBuildingBetweenTwoDate(int id_r, long db, long de){
        logger.info("getConsumptionByEquipment "+id_r +" Between "+db +" "+de);
        return ConsumptionProxy.getConsumptionByBuildingBetweenTwoDate(id_r,db,de);
    }
    public Consumption getConsumptionByIdBuilding(int idb){
        return ConsumptionProxy.getConsumptionByIdBuildingNow(idb);
    }
}
