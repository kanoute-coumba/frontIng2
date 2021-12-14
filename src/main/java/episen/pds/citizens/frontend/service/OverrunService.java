package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.Attribution;
import episen.pds.citizens.frontend.model.Consumption;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import episen.pds.citizens.frontend.repository.MixEnProxy;
import episen.pds.citizens.frontend.repository.OverrunProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OverrunService {

    @Autowired
    private OverrunProxy overrunProxy = new OverrunProxy();
    private static final Logger logger = Logger.getLogger(OverrunService.class.getName());

    public Iterable<Consumption> getConsumption(){
        return overrunProxy.getConsumption();
    }

    public Iterable<Attribution> getAttribution(){
        return overrunProxy.getAttribution();
    }
}
