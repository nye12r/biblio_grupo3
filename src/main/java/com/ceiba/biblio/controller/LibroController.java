package com.ceiba.biblio.controller;

import com.ceiba.biblio.Dto.LibroInDto;
import com.ceiba.biblio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/getInfo")
    public ResponseEntity getInfo(){
        return libroService.getInfo();
    }

    @PostMapping("/crearLibro")
    public ResponseEntity crearLibro(@RequestBody LibroInDto libro){
        return  libroService.crearLibro(libro);
    }
    
    @PostMapping("/eliminarLibro")
    public ResponseEntity eliminarLibro(@RequestBody LibroInDto libro){
        return  libroService.eliminarLibro(libro);
    }
    
}
