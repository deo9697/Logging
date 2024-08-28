package Logging.Logging.controller;


import Logging.Logging.service.CalculationService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoggingController {

    @Autowired
    CalculationService calculationService;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Value("${custom.value1}")
    private Integer value1;

    @Value("${custom.value2}")
    private Integer value2;

    @GetMapping("/")
    public String greetings() {
        logger.info("start greetings");
        return "HELLO!!!";
    }

    @GetMapping("/exp")
    public Integer calcolaEsponente() {
        return calculationService.calcolaEsponente();
    }

    @GetMapping("/get-Errors")
    public String error() {
        logger.error("Custom error triggered");
        throw new RuntimeException("This is a custom error");
    }
}
