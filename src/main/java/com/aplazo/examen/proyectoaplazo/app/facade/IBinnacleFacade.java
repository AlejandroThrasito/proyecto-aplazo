package com.aplazo.examen.proyectoaplazo.app.facade;

import com.aplazo.examen.proyectoaplazo.app.domain.entity.Binnacle;
import com.aplazo.examen.proyectoaplazo.app.web.model.InputSimpleInterestModel;
import com.aplazo.examen.proyectoaplazo.app.web.model.OutputSimpleInterestModel;

import java.util.List;

public interface IBinnacleFacade {
    Binnacle saveBinnacle(InputSimpleInterestModel request, List<OutputSimpleInterestModel> response);
    List<Binnacle> getAllBinnacle();
}
