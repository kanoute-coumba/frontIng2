package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Slf4j
@Component
public class ProductionProxy {
    private static final CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(ProductionProxy.class.getName());


}
