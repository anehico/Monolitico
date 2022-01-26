package com.example.monolito.controller;

import com.example.monolito.model.clienteModel;
import com.example.monolito.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public List<clienteModel> obtenerClientes(){
        return clienteService.listar();
    }

    @PostMapping()
    public ResponseEntity<clienteModel> guardarCliente(@RequestBody clienteModel cliente){
        return new ResponseEntity<>(this.clienteService.save(cliente), HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public Optional<clienteModel> obtenerClienteById(@PathVariable int id){
        return clienteService.listarId(id);
    }

    @GetMapping("/documento/{documento}")
    public Optional<clienteModel> obtenerClienteByDocumento(@PathVariable String documento){
        return clienteService.listarDocumento(documento);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable int id){
        clienteService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<clienteModel> actualizarCliente(@RequestBody clienteModel newCliente, @PathVariable int id){
        return new ResponseEntity<>(clienteService.update(newCliente, id), HttpStatus.OK);
    }
}
