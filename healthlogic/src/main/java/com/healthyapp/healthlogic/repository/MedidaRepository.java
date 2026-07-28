package com.healthyapp.healthlogic.repository;

import com.healthyapp.healthlogic.model.Medida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Long> {
    
    // agregar consultas automáticas con solo nombrar el método:
    List<Medida> findByPacienteDni(Long dni);
    void deleteByIdAndPacienteDni(Long id, Long dni);
}