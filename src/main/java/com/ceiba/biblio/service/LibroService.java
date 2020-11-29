package com.ceiba.biblio.service;

import com.ceiba.biblio.Dto.LibroInDto;
import com.ceiba.biblio.Dto.LibroOutDto;
import com.ceiba.biblio.Dto.ListaLibroOutDto;
import com.ceiba.biblio.Dto.Utilidades;
import com.ceiba.biblio.model.LibroEntity;
import com.ceiba.biblio.model.PrestamoEntity;
import com.ceiba.biblio.repository.LibroRepository;
import com.ceiba.biblio.repository.PrestamoRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.IntStream;
import lombok.experimental.var;
import org.springframework.http.HttpHeaders;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Autowired
    private PrestamoRepository prestamoRepository;
    
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
            respuesta.setMensaje("Libro guardado correctamente");
        }else {
            libr = new LibroEntity();
            libr.setTotalEjemplares(Long.valueOf(1));
            libr.setTotalEjemplaresDisponibles(Long.valueOf(1));
            libr.setIsbn(libro.getIsbn());
            libr.setTitulo(libro.getNombreLibro());
            libr.setLibEspalindrome(esPalindrome(libro.getIsbn()));
            libr.setLibEsconlimite(Utilidades.isOverThirty(libro.getIsbn()));
            libr.setTotalEjemplaresPrestados(Long.valueOf(0));
            respuesta.setMensaje("Libro fue actualizado");
        }
        libroRepository.save(libr);
        respuesta.setEstado("OK");
        return ResponseEntity.ok(respuesta);

    }
    
    public ResponseEntity eliminarLibro(LibroInDto libro) {
        LibroEntity libr = null;
        LibroOutDto respuesta = new LibroOutDto();
        Optional<LibroEntity> lib = libroRepository.findByIsbn(libro.getIsbn());

        if(lib.isPresent()){
            libr=lib.get();
            libr.setTotalEjemplares(libr.getTotalEjemplares()+1);
            libr.setTotalEjemplaresDisponibles(libr.getTotalEjemplaresDisponibles()+1);
            respuesta.setEstado("OK");
            respuesta.setMensaje("Libro eliminado correctamente");
            libroRepository.delete(libr);
        }else {
            respuesta.setEstado("MAL");
            respuesta.setMensaje("Libro no eliminado, no Existe");
        }
        return ResponseEntity.ok(respuesta);
    }

    public boolean esPalindrome(String isbn){
        String isbnTemporal  = isbn.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, isbnTemporal.length() / 2)
                .noneMatch(i -> isbnTemporal.charAt(i) != isbnTemporal.charAt(isbnTemporal.length() - i - 1));
    }
    
    public ResponseEntity consultarLibro(String isbn){
        
        ArrayList<Optional<LibroEntity>> libros = new ArrayList<Optional<LibroEntity>>();
        List<ListaLibroOutDto> listadoLibros = new ArrayList<>();
        if(isbn == null || isbn.equals("")){
            List<LibroEntity> lib = libroRepository.findAll();
            for(LibroEntity i : lib){
                ListaLibroOutDto libDto = new ListaLibroOutDto();
                List<PrestamoEntity> prestamo = prestamoRepository.findByLibId(i);
                if(prestamo.isEmpty()){
                    libDto.setFechaLimite(null);
                    libDto.setNombrePersona("");
                    libDto.setNombreLibro(i.getTitulo());
                    libDto.setIsbn(i.getIsbn());
                    listadoLibros.add(libDto);
                }else{
                    for(PrestamoEntity p : prestamo){
                        libDto = new ListaLibroOutDto();
                        libDto.setFechaLimite(p.getPresFechalimite());
                        libDto.setNombrePersona(p.getPresNombrepersona());
                        libDto.setNombreLibro(i.getTitulo());
                        libDto.setIsbn(i.getIsbn());
                        listadoLibros.add(libDto);
                    }
                }
               
            }
            
        }else{
            libros.add(libroRepository.findByIsbn(isbn));
        }
        
        return ResponseEntity.ok(listadoLibros);
    }
}
