package com.example.deposito_plazo.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
//Esta clase representa la solicitud de un depósito a plazo que se enviará al servidor al crear un nuevo depósito
// Contiene los campos necesarios para crear un nuevo depósito a plazo
public class DepositoPlazoRequest {
    private String numeroCuenta;
    private String nombreCliente;
    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private Integer plazoDias;
}
