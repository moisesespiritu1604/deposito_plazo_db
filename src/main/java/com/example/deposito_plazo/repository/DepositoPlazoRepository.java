package com.example.deposito_plazo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deposito_plazo.model.DepositoPlazo;

public interface DepositoPlazoRepository extends JpaRepository< DepositoPlazo, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar depósitos por número de cuenta o nombre del cliente  
    List<DepositoPlazo> findByNumeroCuenta(String numeroCuenta); // Buscar depósitos por número de cuenta
    List<DepositoPlazo> findByEstado(String estado);// Buscar depósitos por estado

    
}
