package com.ceiba.biblio.service;

import com.ceiba.biblio.Dto.LibroInDto;
import com.ceiba.biblio.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    public ResponseEntity getInfo(){
        
        return ResponseEntity.ok("Respuesta servicio OK");
    }

    public ResponseEntity crearLibro(LibroInDto libro){
        if(esPalindrome(libro.getIsbn())){
            return ResponseEntity.ok("es palindrome");
        }else{
            return null;
        }

    }

    public boolean esPalindrome(String isbn){
        String isbnTemporal  = isbn.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, isbnTemporal.length() / 2)
                .noneMatch(i -> isbnTemporal.charAt(i) != isbnTemporal.charAt(isbnTemporal.length() - i - 1));
    }

}
