package com.aplazo.examen.proyectoaplazo.app.web.model;

import lombok.Getter;
import lombok.experimental.Tolerate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class InputSimpleInterestModel {

    @DecimalMin(value = "1.0", inclusive = false,message = "The amount should be more than $1.00, the max should be lesser than $999,999.00.")
    @DecimalMax(value = "999999.00", inclusive = false,message = "The amount should be more than $1.00, the max should be lesser than $999,999.00.")
    @NotNull(message = "The amount is required")
    private BigDecimal amount;

    @Min(value = 4,message = "The max terms (weeks) were the payment can be paid is 52, the minimum should be 4.")
    @Max(value = 52,message = "The max terms (weeks) were the payment can be paid is 52, the minimum should be 4.")
    @NotNull(message = "The terms is required")
    private Integer terms;

    @DecimalMin(value = "1.0", inclusive = false,message = "The rate should bigger than 1%, lesser than 100%.")
    @DecimalMax(value = "100.0", inclusive = false,message = "The rate should bigger than 1%, lesser than 100%.")
    @NotNull(message = "The rate is required")
    private BigDecimal rate;

    @Tolerate
    protected InputSimpleInterestModel() {
    }
}
