package com.example.monolito.controller;

import com.example.monolito.model.imagenModel;
import com.example.monolito.service.imagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/cliente")
public class imagenController {
    @Autowired
    imagenService imagenRepository;

    @PostMapping("/image/add/{id}")
    public imagenModel addImage( @PathVariable int id, @RequestParam("image") MultipartFile image) throws IOException {
    return imagenRepository.addImagen(id,image);
    }

    @GetMapping("/photos/{id}")
    public imagenModel getImage(@PathVariable int id){
        return imagenRepository.getPhoto(id);
    }

}
