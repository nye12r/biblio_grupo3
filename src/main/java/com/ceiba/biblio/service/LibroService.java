package com.ceiba.biblio.service;

import com.ceiba.biblio.dto.LibroInDto;
import com.ceiba.biblio.dto.LibroOutDto;
import com.ceiba.biblio.dto.ListaLibroOutDto;
import com.ceiba.biblio.dto.Utilidades;
import com.ceiba.biblio.model.LibroEntity;
import com.ceiba.biblio.model.PrestamoEntity;
import com.ceiba.biblio.repository.LibroRepository;
import com.ceiba.biblio.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    public ResponseEntity getInfo() {

        return ResponseEntity.ok("Respuesta servicio OK");
    }

    public ResponseEntity crearLibro(LibroInDto libro) {
        LibroEntity libr = null;
        LibroOutDto respuesta = new LibroOutDto();
        Optional<LibroEntity> lib = libroRepository.findByIsbn(libro.getIsbn());

        if (lib.isPresent()) {
            libr = lib.get();
            libr.setTotalEjemplares(libr.getTotalEjemplares() + 1);
            libr.setTotalEjemplaresDisponibles(libr.getTotalEjemplaresDisponibles() + 1);
            respuesta.setMensaje("Libro guardado correctamente");
        } else {
            libr = new LibroEntity();
            libr.setTotalEjemplares(Long.valueOf(1));
            libr.setTotalEjemplaresDisponibles(Long.valueOf(1));
            libr.setIsbn(libro.getIsbn());
            libr.setTitulo(libro.getNombreLibro());
            libr.setLibEspalindrome(Utilidades.isPalindrome(libro.getIsbn()));
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

        if (!lib.isPresent()) {
            return ResponseEntity.badRequest().body("Libro no eliminado, no Existe");
        }
        libr = lib.get();
        if (libr.getTotalEjemplares() == 0) {
            return ResponseEntity.badRequest().body("El libro indicado no tiene ejemplares");
        }
        if (libr.getTotalEjemplaresDisponibles() == 0) {
            return ResponseEntity.badRequest().body("El libro indicado tiene todos sus ejemplares en prestamo");
        }
        if (libr.getTotalEjemplares() == 1) {
            libroRepository.delete(libr);
            respuesta.setEstado("OK");
            respuesta.setMensaje("Libro eliminado correctamente");
        } else {
            libr.setTotalEjemplares(libr.getTotalEjemplares() - 1);
            libr.setTotalEjemplaresDisponibles(libr.getTotalEjemplaresDisponibles() - 1);
            libroRepository.save(libr);
            respuesta.setEstado("OK");
            respuesta.setMensaje("ejemplar eliminado correctamente");
        }

        return ResponseEntity.ok(respuesta);
    }

    public ResponseEntity consultarLibros() {

        List<ListaLibroOutDto> listadoLibros = new ArrayList<>();

        List<LibroEntity> lib = libroRepository.findAll();
        for (LibroEntity i : lib) {
            ListaLibroOutDto libDto = new ListaLibroOutDto();
            List<PrestamoEntity> prestamo = prestamoRepository.findByLibId(i);
            if (prestamo.isEmpty()) {
                libDto.setFechaLimite(null);
                libDto.setNombrePersona("");
                libDto.setNombreLibro(i.getTitulo());
                libDto.setIsbn(i.getIsbn());
                listadoLibros.add(libDto);
            } else {
                for (PrestamoEntity p : prestamo) {
                    libDto = new ListaLibroOutDto();
                    libDto.setFechaLimite(p.getPresFechalimite());
                    libDto.setNombrePersona(p.getPresNombrepersona());
                    libDto.setNombreLibro(i.getTitulo());
                    libDto.setIsbn(i.getIsbn());
                    listadoLibros.add(libDto);
                }
            }
        }

        return ResponseEntity.ok(listadoLibros);
    }
}
