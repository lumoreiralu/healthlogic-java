package com.healthyapp.healthlogic.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.healthyapp.healthlogic.dto.MedidaDTO;
import com.healthyapp.healthlogic.service.MedidaService;


@RestController
@RequestMapping("/api/pacientes/{dni}/medidas")
@CrossOrigin(origins = "*")
public class MedidaController {

    private final MedidaService medidaService;

    public MedidaController(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    @GetMapping
    public List<MedidaDTO> obtenerMedidas(@PathVariable Long dni) {
        return medidaService.obtenerMedidasPorPaciente(dni);
    }

    @PostMapping
    public ResponseEntity<MedidaDTO> agregarMedida(
            @PathVariable Long dni,
            @RequestBody MedidaDTO medidaDTO) {
            
        MedidaDTO nuevaMedida = medidaService.agregarMedida(dni, medidaDTO);
        return new ResponseEntity<>(nuevaMedida, HttpStatus.CREATED);
    }
}