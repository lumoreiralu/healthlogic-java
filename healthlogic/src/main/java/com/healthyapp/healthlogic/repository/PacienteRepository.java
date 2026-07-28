package com.healthyapp.healthlogic.repository;

import com.healthyapp.healthlogic.model.Paciente;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    
} 
