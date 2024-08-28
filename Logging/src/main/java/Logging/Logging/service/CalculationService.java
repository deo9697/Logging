package Logging.Logging.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    Logger logger = LoggerFactory.getLogger(CalculationService.class);

    @Value("${custom.value1}")
    private Integer value1;

    @Value("${custom.value2}")
    private Integer value2;

    public Integer calcolaEsponente() {
        logger.info("start calcolo");
        Integer risultato = (int) Math.pow(value1, value2);
        logger.info("calcolo terminato");
        return risultato;
    }
}
