package com.aplazo.examen.proyectoaplazo.app.web.controller;

import com.aplazo.examen.proyectoaplazo.app.domain.entity.Binnacle;
import com.aplazo.examen.proyectoaplazo.app.service.InterestService;
import com.aplazo.examen.proyectoaplazo.app.web.model.InputSimpleInterestModel;
import com.aplazo.examen.proyectoaplazo.app.web.model.OutputSimpleInterestModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.aplazo.examen.proyectoaplazo.util.Constantes.CONTEXT_BINNACLE;
import static com.aplazo.examen.proyectoaplazo.util.Constantes.CONTEXT_INTEREST;

@RestController
@RequestMapping(value = CONTEXT_INTEREST)
public class InterestController {
    private final InterestService service;

    @Autowired
    public InterestController(InterestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<List<OutputSimpleInterestModel>>calculateSimpleInterest(@RequestBody @Valid InputSimpleInterestModel model){
        return ResponseEntity.ok().body(service.calculateSimpleInterest(model));
    }


    @GetMapping(value = CONTEXT_BINNACLE, produces = "application/json" )
    public ResponseEntity<List<Binnacle>> getAllBinnacle(){
        return ResponseEntity.ok().body(service.getAllBinnacle());
    }
}
