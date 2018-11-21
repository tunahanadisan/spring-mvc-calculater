package tr.com.etstur.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tr.com.etstur.common.Operator;

import java.math.BigDecimal;


@Service
public class CalculatorService implements ICalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    /**
     * Method is used for calculation for given operator types
     *
     * @param firstNumber
     * @param secondNumber
     * @param operator
     * @return
     */
    @Override
    public double calculate(BigDecimal firstNumber,
                            BigDecimal secondNumber,
                            Operator operator) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Result is being calculating : {} {} {}", firstNumber, operator, secondNumber);
        }

        switch (operator) {
            case ADD:
                return firstNumber.add(secondNumber).doubleValue();
            case SUBSTRACT:
                return firstNumber.subtract(secondNumber).doubleValue();
            case MULTIPLY:
                return firstNumber.multiply(secondNumber).doubleValue();
            case DIVIDE:
                return firstNumber.divide(secondNumber, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            default:
                LOGGER.error("Unsupported operation is given for calculation: {}", operator);
                throw new RuntimeException("Unsupported operation is given for calculation");

        }
    }
}
