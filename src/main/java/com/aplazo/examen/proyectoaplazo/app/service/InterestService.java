package com.aplazo.examen.proyectoaplazo.app.service;

import com.aplazo.examen.proyectoaplazo.app.domain.entity.Binnacle;
import com.aplazo.examen.proyectoaplazo.app.facade.IBinnacleFacade;
import com.aplazo.examen.proyectoaplazo.app.web.model.InputSimpleInterestModel;
import com.aplazo.examen.proyectoaplazo.app.web.model.OutputSimpleInterestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.aplazo.examen.proyectoaplazo.util.Constantes.calculateInterestPerWeek;
import static com.aplazo.examen.proyectoaplazo.util.Constantes.calculatePaymentAmount;
import static com.aplazo.examen.proyectoaplazo.util.Constantes.calculatePaymentDay;

@Service
public class InterestService {
    private final IBinnacleFacade facade;

    @Autowired
    public InterestService(IBinnacleFacade facade) {
        this.facade = facade;
    }

    public List<OutputSimpleInterestModel> calculateSimpleInterest(InputSimpleInterestModel model){
        BigDecimal interestPerWeek = calculateInterestPerWeek(model.getAmount(),model.getRate());
        BigDecimal amount = calculatePaymentAmount(model.getAmount(),interestPerWeek,model.getTerms());
        List<OutputSimpleInterestModel> response = new ArrayList<>();
        Integer week = 1;
        while(model.getTerms() > (week-1)){
            response.add(OutputSimpleInterestModel.builder()
                    .amount(amount)
                    .paymentNumber(week)
                    .paymentDate(calculatePaymentDay(week))
                    .build());
            week++;
        }
        facade.saveBinnacle(model,response);
        return response;
    }

    public List<Binnacle> getAllBinnacle(){
        return facade.getAllBinnacle();
    }

}
