package com.example.deposito_plazo.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deposito_plazo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositoPlazo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(name = "tasa_interes", nullable = false)
    private BigDecimal tasaInteres;

    @Column(name = "plazo_dias", nullable = false)
    private Integer plazoDias;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDateTime fechaVencimiento;

    @Column(name = "interes_ganado", nullable = false)
    private BigDecimal interesGanado;

    @Column
    private String estado; // Puede ser "activo", "vencido", "cancelado", etc.

    @PrePersist
    public void PrePersist() {
        this.fechaSolicitud = LocalDateTime.now();
        // Calcular fecha de vencimiento
        this.fechaVencimiento = this.fechaSolicitud.plusMonths(plazoDias);
        this.estado = "activo"; // Estado inicial al crear el depósito
        // Calcular interés ganado
        interesGanado = this.monto.multiply(this.tasaInteres).multiply(new BigDecimal(this.plazoDias)).divide(new BigDecimal(365), 2, RoundingMode.HALF_UP);
        
    }
}
