package com.example.monolito.service;

import com.example.monolito.interfaceService.InterfaceImagenService;
import com.example.monolito.model.imagenModel;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.monolito.interfaces.InterfaceImagen;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@Service
public class imagenService implements InterfaceImagenService {
    @Autowired
    private InterfaceImagen imagenRepo;

    @Override
    public imagenModel addImagen(int id, MultipartFile file) throws IOException {
        imagenModel imagen= new imagenModel(id);
        imagen.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imagenRepo.insert(imagen);
        return imagen;
    }

    @Override
    public Optional<imagenModel> getPhoto(int id) {
        return (Optional<imagenModel>) imagenRepo.findById(id);
    }

    @Override
    public Object deleteImage(int id){
        imagenRepo.deleteById(id);
        return null;
    }

    @Override
    public Optional<imagenModel> updateImage(int id, MultipartFile file) throws IOException {
        return Optional.ofNullable(imagenRepo.findById(id)
                .map(
                        imagen -> {
                            try {
                                imagen.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
                            } catch (IOException e) {
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
                            }
                            return imagenRepo.save(imagen);
                        }).orElseGet(() -> {
                    return null;
                }));
    }
}
