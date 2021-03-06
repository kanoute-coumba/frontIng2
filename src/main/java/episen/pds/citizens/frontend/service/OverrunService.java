package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.*;
import episen.pds.citizens.frontend.repository.OverrunProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OverrunService {

    @Autowired
    private OverrunProxy overrunProxy;
    private static final Logger logger = Logger.getLogger(OverrunService.class.getName());

    public Iterable<Attribution> getAttribAfterMock() {
        return overrunProxy.getAttribAfterMock();

    }

    public Iterable<ConsoByDay> getConsoAfterMock() {
        return overrunProxy.getConsoAfterMock();

    }

    public Iterable<ConsoByDay> getConsumption(){
        return overrunProxy.getConsumption();
    }

    public Iterable<PeakDay> getPeakDay(){
        return overrunProxy.getPeakDay();
    }

    public Iterable<PeakYear> getPeak(){
        return overrunProxy.getPeak();
    }

    public Iterable<PeakMonth> getPeak20(){
        return overrunProxy.getPeak20();
    }

    public Iterable<PeakMonth> getPeak21(){
        return overrunProxy.getPeak21();
    }

    public Iterable<PeakMonth> getPeak22(){
        return overrunProxy.getPeak22();
    }

    public Iterable<Attribution> getAttribution() { return overrunProxy.getAttribution();
    }
}
