package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.OccupationRate;
import episen.pds.citizens.frontend.repository.OccupationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OccupationService {

    @Autowired
    private OccupationProxy occupationProxy;
    private static final Logger logger = Logger.getLogger(OccupationService.class.getName());

    public Iterable<OccupationRate> getOccupationRate() {
        return occupationProxy.OccupationRate();

    }

}
