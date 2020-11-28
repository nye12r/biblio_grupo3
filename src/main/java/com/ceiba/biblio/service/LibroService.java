package com.ceiba.biblio.service;

import com.ceiba.biblio.Dto.LibroInDto;
import com.ceiba.biblio.Dto.LibroOutDto;
import com.ceiba.biblio.model.LibroEntity;
import com.ceiba.biblio.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    public ResponseEntity getInfo(){
        
        return ResponseEntity.ok("Respuesta servicio OK");
    }

    public ResponseEntity crearLibro(LibroInDto libro) {
        LibroOutDto respuesta = new LibroOutDto();
        Optional<LibroEntity> lib = libroRepository.findByIsbn(libro.getIsbn());

        if (!lib.isPresent()) {
            LibroEntity libr = new LibroEntity();
            libr.setIsbn(libro.getIsbn());
            libr.setTitulo(libro.getNombreLibro());
            libr.setLibEspalindrome(esPalindrome(libro.getIsbn()));
            libr.setLibEsconlimite(true);
            libr.setTotalEjemplares(Long.valueOf(100));
            libr.setTotalEjemplaresDisponibles(Long.valueOf(99));
            libr.setTotalEjemplaresPrestados(Long.valueOf(1));
            libroRepository.save(libr);
            respuesta.setEstado("OK");
            respuesta.setMensaje("Libro guardado correctamente");
            return ResponseEntity.ok(respuesta);
        }
        respuesta.setEstado("Mal");
        respuesta.setMensaje("Libro no se guardado correctamente");
        return ResponseEntity.badRequest().body(respuesta);


    }

    public boolean esPalindrome(String isbn){
        String isbnTemporal  = isbn.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, isbnTemporal.length() / 2)
                .noneMatch(i -> isbnTemporal.charAt(i) != isbnTemporal.charAt(isbnTemporal.length() - i - 1));
    }

}
