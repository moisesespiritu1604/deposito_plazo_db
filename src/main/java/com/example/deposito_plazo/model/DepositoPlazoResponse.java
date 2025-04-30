package com.example.deposito_plazo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Esta clase representa la respuesta que se enviará al cliente al crear un depósito a plazo
// Contiene los campos que se devolverán al cliente después de crear un nuevo depósito a plazo
public class DepositoPlazoResponse {
    private Long id;
    private String numeroCuenta;
    private String nombreCliente;
    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private Integer plazoDias;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaVencimiento;
    private BigDecimal interesGanado;
    private String estado;
}
