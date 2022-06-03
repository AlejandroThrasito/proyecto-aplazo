package com.aplazo.examen.proyectoaplazo.app.domain.repository;

import com.aplazo.examen.proyectoaplazo.app.domain.entity.Binnacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinnacleRepository extends JpaRepository<Binnacle, Integer> {

}
