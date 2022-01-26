package com.example.monolito.interfaceService;

import com.example.monolito.model.clienteModel;
import com.example.monolito.service.ClienteService;

import java.util.List;
import java.util.Optional;

public interface interfaceClienteService {
    public List<clienteModel> listar();
    public Optional<clienteModel> listarId(int id);
    public Optional<clienteModel> listarDocumento(String documento);
    public clienteModel save(clienteModel cliente);
    public void delete(int id);
    public clienteModel update(clienteModel cliente,int id);
}

