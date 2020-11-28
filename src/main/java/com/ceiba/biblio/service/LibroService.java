package com.ceiba.biblio.service;

import com.ceiba.biblio.Dto.LibroInDto;
import com.ceiba.biblio.Dto.LibroOutDto;
import com.ceiba.biblio.Dto.Utilidades;
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
        LibroEntity libr = null;
        LibroOutDto respuesta = new LibroOutDto();
        Optional<LibroEntity> lib = libroRepository.findByIsbn(libro.getIsbn());


        if(lib.isPresent()){
            libr=lib.get();
            libr.setTotalEjemplares(libr.getTotalEjemplares()+1);
            libr.setTotalEjemplaresDisponibles(libr.getTotalEjemplaresDisponibles()+1);
        }else {
            libr = new LibroEntity();
            libr.setTotalEjemplares(Long.valueOf(1));
            libr.setTotalEjemplaresDisponibles(Long.valueOf(1));
            libr.setIsbn(libro.getIsbn());
            libr.setTitulo(libro.getNombreLibro());
            libr.setLibEspalindrome(esPalindrome(libro.getIsbn()));
            libr.setLibEsconlimite(Utilidades.isOverThirty(libro.getIsbn()));
            libr.setTotalEjemplaresPrestados(Long.valueOf(0));
        }
        libroRepository.save(libr);
        respuesta.setEstado("OK");
        respuesta.setMensaje("Libro guardado correctamente");
        return ResponseEntity.ok(respuesta);

    }

    public boolean esPalindrome(String isbn){
        String isbnTemporal  = isbn.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, isbnTemporal.length() / 2)
                .noneMatch(i -> isbnTemporal.charAt(i) != isbnTemporal.charAt(isbnTemporal.length() - i - 1));
    }
}
