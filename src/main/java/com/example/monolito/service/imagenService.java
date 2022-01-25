package com.example.monolito.service;

import com.example.monolito.model.imagenModel;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.monolito.interfaces.InterfaceImagen;

import java.io.IOException;

@Service
public class imagenService {
    @Autowired
    private InterfaceImagen imagenRepo;

    public imagenModel addImagen(int id, MultipartFile file) throws IOException {
        imagenModel imagen= new imagenModel(id);
        imagen.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imagen = imagenRepo.insert(imagen);
        return imagen;
    }

    public imagenModel getPhoto(int id) {
        return imagenRepo.findById(id).get();
    }
}
