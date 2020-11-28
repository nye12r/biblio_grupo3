package com.ceiba.biblio.controller;

import com.ceiba.biblio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/getInfo")
    public ResponseEntity getInfo(){
        return libroService.getInfo();
    }
    
}
