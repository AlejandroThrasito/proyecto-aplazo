package com.aplazo.examen.proyectoaplazo.app.web.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class OutputSimpleInterestModel {
    private Integer paymentNumber;
    private BigDecimal amount;
    private LocalDate paymentDate;
}
