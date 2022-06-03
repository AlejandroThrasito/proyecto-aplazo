package com.aplazo.examen.proyectoaplazo.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public interface Constantes {
    String CONTEXT_INTEREST ="/simple-interest";
    String CONTEXT_BINNACLE ="/binnacle";
    Integer SEVEN_DAYS = 7;
    Integer YEAR = 360;

    ObjectMapper om = new ObjectMapper();

    static BigDecimal calculateInterestPerWeek(BigDecimal amount,BigDecimal rate){
       return amount.multiply(rate.divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP))
               .multiply(BigDecimal.valueOf(SEVEN_DAYS))
               .divide(BigDecimal.valueOf(YEAR),2, RoundingMode.HALF_UP);
    }

    static BigDecimal calculatePaymentAmount(BigDecimal amount,BigDecimal interestPerWeek,Integer terms){
        return amount.add(interestPerWeek.multiply(BigDecimal.valueOf(terms)))
                .divide(BigDecimal.valueOf(terms), 2, RoundingMode.HALF_UP);

    }

    static LocalDate calculatePaymentDay(int week){
        return LocalDate.now()
                .plusWeeks(week);
    }

}
