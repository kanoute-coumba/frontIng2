package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.repository.SmartGridProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartGridService {
    @Autowired
    private SmartGridProxy smartGridProxy;

    public Double smartgrid() {
        return smartGridProxy.smartgrid();
    }
}
