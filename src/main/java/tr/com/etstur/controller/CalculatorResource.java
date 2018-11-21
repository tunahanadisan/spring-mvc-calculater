package tr.com.etstur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.etstur.common.Operator;
import tr.com.etstur.service.CalculatorService;
import tr.com.etstur.service.ICalculatorService;

import java.math.BigDecimal;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class CalculatorResource {


    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorResource.class);

    @Autowired
    private ICalculatorService calculatorService;


    @GetMapping(value = "/calculate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Double> calculate(@RequestParam(name = "first") BigDecimal firstNumber,
                                            @RequestParam(name = "second") BigDecimal secondNumber,
                                            @RequestParam(name = "operator") Operator operator) {

        double result = calculatorService.calculate(firstNumber, secondNumber, operator);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
