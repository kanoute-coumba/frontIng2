package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.repository.MixEnProxy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class MixEnService {

    @Autowired
    private MixEnProxy mixEnProxy = new MixEnProxy();
    private static final Logger logger = Logger.getLogger(MixEnProxy.class.getName());

    public Iterable<MixEn> getMixEn(){
        return mixEnProxy.getCurrentMixEn();
    }

}
