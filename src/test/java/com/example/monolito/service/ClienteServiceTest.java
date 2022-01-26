package com.example.monolito.service;

import com.example.monolito.interfaces.InterfaceCliente;
import com.example.monolito.model.clienteModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @Mock
    InterfaceCliente interfaceCliente;

    @InjectMocks
    private ClienteService clienteService;

    private clienteModel cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente= new clienteModel();
        cliente.setNombres("Andrés Felipe Hinojosa");
        cliente.setCiudad_nacimiento("Tuluá");
        cliente.setCodigo_identificacion("1116252516");
        cliente.setTipo_identificacion(1);
        cliente.setEdad(14);
    }

    @Test
    void listar() {
        when(interfaceCliente.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteService.listar());
    }

    @Test
    void save() {
        when(interfaceCliente.save(any(clienteModel.class))).thenReturn(cliente);
        assertNotNull(clienteService.save(new clienteModel()));
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

}