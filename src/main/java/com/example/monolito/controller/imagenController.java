package com.example.monolito.controller;

import com.example.monolito.model.imagenModel;
import com.example.monolito.service.imagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class imagenController {
    @Autowired
    imagenService imagenRepository;

    @PostMapping("/image/add/{id}")
    public imagenModel addImage( @PathVariable int id, @RequestParam("image") MultipartFile image) throws IOException {
    return imagenRepository.addImagen(id,image);
    }

    @GetMapping("/image/{id}")
    public Optional<imagenModel> getImage(@PathVariable int id){
        return imagenRepository.getPhoto(id);
    }

    @DeleteMapping("/image/{id}")
    ResponseEntity deleteImage(@PathVariable int id){
        imagenRepository.deleteImage(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/image/{id}")
    public imagenModel updateImage(@PathVariable int id, @RequestParam("image") MultipartFile image) throws IOException{
        return imagenRepository.updateImage(id, image);
    }
}
