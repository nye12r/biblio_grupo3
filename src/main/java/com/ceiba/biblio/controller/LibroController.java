package com.ceiba.biblio.controller;

import com.ceiba.biblio.Dto.LibroInDto;
import com.ceiba.biblio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
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
    
    @GetMapping("/buscar")
    public ResponseEntity buscar() {
        return libroService.consultarLibro("");
    }
    
}
