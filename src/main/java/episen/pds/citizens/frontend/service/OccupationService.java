package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.*;
import episen.pds.citizens.frontend.repository.OccupationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OccupationService {

    @Autowired
    private OccupationProxy occupationProxy;
    private static final Logger logger = Logger.getLogger(OccupationService.class.getName());

    public Iterable<Tenant> getTenant() {
        return occupationProxy.getTenant();
    }

    public Iterable<DWPbyBuilding> getDWPbuildings() {
        return occupationProxy.getDWPbuildings();
    }

    public Iterable<TenantDetails> getTenantDetails() {
        return occupationProxy.getTenantDetails();
    }

    public Iterable<RentCounterByYear> getCounterByYear() {
        return occupationProxy.getCounterByYear();
    }

    public Iterable<OccupationRate> getOccupationRate() {
        return occupationProxy.getOccupationRate();
    }

    public Iterable<OccupationRateByBuilding> get2020Rate() {
        return occupationProxy.get2020Rate();

    }

    public Iterable<OccupationRateByBuilding> get2021Rate() {
        return occupationProxy.get2021Rate();

    }

    public Iterable<OccupationRateByBuilding> get2022Rate() {
        return occupationProxy.get2022Rate();

    }

}
