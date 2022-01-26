package com.example.monolito.interfaces;

import com.example.monolito.model.clienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterfaceCliente extends JpaRepository<clienteModel, Integer> {
    @Query(value = "select * from cliente WHERE cliente.codigo_identificacion=?1", nativeQuery=true)
    Optional<clienteModel> findByDocumento(String documento);
}

