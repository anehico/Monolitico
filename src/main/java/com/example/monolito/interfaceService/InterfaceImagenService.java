package com.example.monolito.interfaceService;

import com.example.monolito.model.imagenModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface InterfaceImagenService {
    public imagenModel addImagen(int id, MultipartFile file) throws IOException;
    public imagenModel getPhoto(int id);
    public void deleteImage(int id);
    public imagenModel updateImage(int id, MultipartFile file) throws IOException;
}
