package com.example.monolito.interfaceService;

import com.example.monolito.model.imagenModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface InterfaceImagenService {
    public imagenModel addImagen(int id, MultipartFile file) throws IOException;
    public Optional<imagenModel> getPhoto(int id);
    public void deleteImage(int id);
    public imagenModel updateImage(int id, MultipartFile file) throws IOException;
}
