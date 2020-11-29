package com.ceiba.biblio.controller;

import com.ceiba.biblio.dto.LibroInDto;
import com.ceiba.biblio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/getInfo")
    public ResponseEntity getInfo() {
        return libroService.getInfo();
    }

    @PostMapping("/crearLibro")
    public ResponseEntity crearLibro(@RequestBody LibroInDto libro) {
        return libroService.crearLibro(libro);
    }

    @GetMapping("/consultarLibros")
    public ResponseEntity consultarLibros() {
        return libroService.consultarLibros();
    }

    @PostMapping("/eliminarLibro")
    public ResponseEntity eliminarLibro(@RequestBody LibroInDto libro) {
        return libroService.eliminarLibro(libro);
    }

}
