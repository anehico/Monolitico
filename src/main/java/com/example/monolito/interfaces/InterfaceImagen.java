package com.example.monolito.interfaces;

import com.example.monolito.model.imagenModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceImagen extends MongoRepository<imagenModel, Integer> { }
