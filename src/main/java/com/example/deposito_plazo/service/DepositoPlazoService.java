package com.example.deposito_plazo.service;

import java.util.List;

import com.example.deposito_plazo.model.DepositoPlazoRequest;
import com.example.deposito_plazo.model.DepositoPlazoResponse;

public interface DepositoPlazoService {
    /**
     * Registra una nueva solicitud de depósito a plazo
     * @param request Datos de la solicitud
     * @return Respuesta con los datos del depósito registrado
     */
    DepositoPlazoResponse registrarDeposito(DepositoPlazoRequest request);

    /**
     * Obtiene todas las solicitudes de depósito a plazo
     * @return Lista de depósitos a plazo
     */
    List<DepositoPlazoResponse> listarDepositosPlazo();

    /**
     * Actualiza una solicitud de depósito a plazo existente
     * @param id ID del depósito a plazo a actualizar
     * @param request Datos de la solicitud actualizada
     * @return Respuesta con los datos del depósito actualizado
     */
    //DepositoPlazoResponse actualizarDeposito(Long id, DepositoPlazoRequest request);

}
