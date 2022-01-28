package com.example.monolito.service;

import com.example.monolito.interfaces.InterfaceImagen;
import com.example.monolito.model.imagenModel;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class imagenServiceTest {

    @Mock
    InterfaceImagen imagenInterface;

    @InjectMocks
    imagenService imagenSer;

    private imagenModel imagen;

    private   MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
            "text/plain", "Spring Framework".getBytes());

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        imagen = new imagenModel();
        imagen.setImage(any(Binary.class));
        imagen.setId(2);
    }

    @Test
    void addImagen() throws IOException {
        when(imagenSer.addImagen(imagen.getId(), multipartFile)).thenReturn(imagen);
        assertNotNull(imagenSer.addImagen(imagen.getId(), multipartFile));
    }

    @Test
    void getPhoto() {
        when(imagenSer.getPhoto(imagen.getId())).thenReturn(Optional.of(imagen));
        assertNotNull(imagenSer.getPhoto(imagen.getId()));
    }

    @Test
    void deleteImage() {
    }

    @Test
    void updateImage() {
    }
}