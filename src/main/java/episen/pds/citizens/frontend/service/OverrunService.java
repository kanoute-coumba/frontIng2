package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.*;
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

    public Iterable<Consobyday> getConsumption(){
        return overrunProxy.getConsumption();
    }

    public Iterable<Attribution> getAttribution(){
        return overrunProxy.getAttribution();
    }
}
