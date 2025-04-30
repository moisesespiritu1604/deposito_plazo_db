package com.example.deposito_plazo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.deposito_plazo.model.DepositoPlazo;
import com.example.deposito_plazo.model.DepositoPlazoRequest;
import com.example.deposito_plazo.model.DepositoPlazoResponse;
import com.example.deposito_plazo.repository.DepositoPlazoRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DepositoPlazoServiceImpl implements DepositoPlazoService {

    private final DepositoPlazoRepository depositoPlazoRepository;

    @Autowired
    public DepositoPlazoServiceImpl(DepositoPlazoRepository depositoPlazoRepository) {
        this.depositoPlazoRepository = depositoPlazoRepository;
    }

    @Override
    public DepositoPlazoResponse registrarDeposito(DepositoPlazoRequest request) {
        // Convertir request a entidad
        DepositoPlazo depositoPlazo = new DepositoPlazo();
        depositoPlazo.setNumeroCuenta(request.getNumeroCuenta());
        depositoPlazo.setNombreCliente(request.getNombreCliente());
        depositoPlazo.setMonto(request.getMonto());
        depositoPlazo.setTasaInteres(request.getTasaInteres());
        depositoPlazo.setPlazoDias(request.getPlazoDias());
        
        // Guardar en la base de datos
        DepositoPlazo depositoGuardado = depositoPlazoRepository.save(depositoPlazo);
        
        // Convertir entidad a response
        return convertirAResponse(depositoGuardado);
    }

    @Override
    @Transactional(readOnly=true)
    public List<DepositoPlazoResponse> listarDepositosPlazo() {
        return depositoPlazoRepository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una entidad DepositoPlazo a un DTO DepositoPlazoResponse
     */
    private DepositoPlazoResponse convertirAResponse(DepositoPlazo depositoPlazo) {
        return DepositoPlazoResponse.builder()
                .id(depositoPlazo.getId())
                .numeroCuenta(depositoPlazo.getNumeroCuenta())
                .nombreCliente(depositoPlazo.getNombreCliente())
                .monto(depositoPlazo.getMonto())
                .tasaInteres(depositoPlazo.getTasaInteres())
                .plazoDias(depositoPlazo.getPlazoDias())
                .fechaSolicitud(depositoPlazo.getFechaSolicitud())
                .fechaVencimiento(depositoPlazo.getFechaVencimiento())
                .interesGanado(depositoPlazo.getInteresGanado())
                .estado(depositoPlazo.getEstado())
                .build();
    }

    
}
