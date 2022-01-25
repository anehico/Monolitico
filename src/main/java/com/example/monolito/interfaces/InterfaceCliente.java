package com.example.monolito.interfaces;

import com.example.monolito.model.clienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceCliente extends CrudRepository<clienteModel, Integer> {
}
