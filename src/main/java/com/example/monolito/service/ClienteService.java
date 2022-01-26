package com.example.monolito.service;

import com.example.monolito.interfaceService.interfaceClienteService;
import com.example.monolito.interfaces.InterfaceCliente;


import com.example.monolito.model.clienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements interfaceClienteService {
    @Autowired
    InterfaceCliente interfaceCliente;

    @Override
    public List<clienteModel> listar() {
        return (List<clienteModel>) interfaceCliente.findAll();
    }

    @Override
    public Optional<clienteModel> listarId(int id) {
        return interfaceCliente.findById(id);
    }

    @Override
    public Optional<clienteModel> listarDocumento(String documento){
        return interfaceCliente.findByDocumento(documento);
    }

    @Override
    public clienteModel save(clienteModel cliente) {
        try {
            if(cliente.getEdad()<18){
                throw new Exception("El cliente debe ser mayor de edad");
            }
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
        return interfaceCliente.save(cliente);
    }

    @Override
    public void delete(int id) {
        interfaceCliente.deleteById(id);
    }

    public clienteModel update(clienteModel newCliente, int id) {
       return interfaceCliente.findById(id)
                .map(
                        cliente -> {
                            cliente.setNombres(newCliente.getNombres());
                            cliente.setTipo_identificacion(newCliente.getTipo_identificacion());
                            cliente.setCodigo_identificacion(newCliente.getCodigo_identificacion());
                            cliente.setEdad(newCliente.getEdad());
                            cliente.setCiudad_nacimiento(newCliente.getCiudad_nacimiento());
                            return interfaceCliente.save(cliente);
                        }).orElseGet(() -> {
            return interfaceCliente.save(newCliente);
        });
    }
}
