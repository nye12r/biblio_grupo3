package com.ceiba.biblio.service;

import com.ceiba.biblio.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    public ResponseEntity getInfo(){
        
        return ResponseEntity.ok("ServiciLibro");
    }
    
}
