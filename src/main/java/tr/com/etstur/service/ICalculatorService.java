package tr.com.etstur.service;

import tr.com.etstur.common.Operator;

import java.math.BigDecimal;

public interface ICalculatorService {


    /**
     * Method is used for calculation for given numbers and operator type
     *
     * @param firstNumber
     * @param secondNumber
     * @param operator
     * @return
     */
    double calculate(BigDecimal firstNumber, BigDecimal secondNumber, Operator operator);

}
