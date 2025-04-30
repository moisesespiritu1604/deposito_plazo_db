package com.example.deposito_plazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.deposito_plazo.model.DepositoPlazoRequest;
import com.example.deposito_plazo.model.DepositoPlazoResponse;
import com.example.deposito_plazo.service.DepositoPlazoService;

@RestController
@RequestMapping("/api/deposito-plazo") // URL base para las solicitudes de depósito a plazo
// Esta clase es el controlador REST para manejar las solicitudes relacionadas con los depósitos a plazo
public class DepositoPlazoController {
    private final DepositoPlazoService depositoPlazoService;

    @Autowired
    public DepositoPlazoController(DepositoPlazoService depositoPlazoService) {
        this.depositoPlazoService = depositoPlazoService;
    }

    /**
     * Endpoint para registrar un nuevo depósito a plazo
     * @param request Datos del depósito a plazo
     * @return Depósito a plazo registrado
     */
    @PostMapping
    public ResponseEntity<DepositoPlazoResponse> registrarDepositoPlazo(@RequestBody DepositoPlazoRequest request) {
        DepositoPlazoResponse response = depositoPlazoService.registrarDeposito(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Endpoint para listar todos los depósitos a plazo
     * @return Lista de depósitos a plazo
     */
    @GetMapping
    public ResponseEntity<List<DepositoPlazoResponse>> listarDepositosPlazo() {
        List<DepositoPlazoResponse> depositos = depositoPlazoService.listarDepositosPlazo();
        return ResponseEntity.ok(depositos);
    }

}
