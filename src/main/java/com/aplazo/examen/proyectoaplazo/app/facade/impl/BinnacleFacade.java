package com.aplazo.examen.proyectoaplazo.app.facade.impl;

import com.aplazo.examen.proyectoaplazo.app.domain.entity.Binnacle;
import com.aplazo.examen.proyectoaplazo.app.domain.repository.BinnacleRepository;
import com.aplazo.examen.proyectoaplazo.app.facade.IBinnacleFacade;
import com.aplazo.examen.proyectoaplazo.app.web.model.InputSimpleInterestModel;
import com.aplazo.examen.proyectoaplazo.app.web.model.OutputSimpleInterestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class BinnacleFacade implements IBinnacleFacade {
    private final BinnacleRepository repository;

    @Autowired
    public BinnacleFacade(BinnacleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = false)
    public Binnacle saveBinnacle(InputSimpleInterestModel request, List<OutputSimpleInterestModel> response) {
        return repository.save(Binnacle.builder()
                .dateRegister(LocalDateTime.now())
                .request(request)
                .response(response)
                .build());
    }
    @Override
    public List<Binnacle> getAllBinnacle(){
        return repository.findAll();
    }
}
