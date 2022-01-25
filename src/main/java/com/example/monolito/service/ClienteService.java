package com.example.monolito.service;

import com.example.monolito.interfaceService.interfaceClienteService;
import com.example.monolito.interfaces.InterfaceCliente;


import com.example.monolito.model.clienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return Optional.empty();
    }

    @Override
    public clienteModel save(clienteModel cliente) {
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
