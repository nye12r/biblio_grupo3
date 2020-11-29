/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.service;

import com.ceiba.biblio.Dto.PrestamoInDto;
import com.ceiba.biblio.Dto.PrestamoOutDto;
import com.ceiba.biblio.Dto.Utilidades;
import com.ceiba.biblio.model.LibroEntity;
import com.ceiba.biblio.model.PrestamoEntity;
import com.ceiba.biblio.repository.LibroRepository;
import com.ceiba.biblio.repository.PrestamoRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gustavo
 */
@Service
public class PrestamoService {
    
    @Autowired
    private PrestamoRepository prestamoRepository;
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity prestarLibro(PrestamoInDto prestamo) {
        Optional<LibroEntity> lib = libroRepository.findByIsbn(prestamo.getIsbn());
        
        if (!lib.isPresent()) {
            return ResponseEntity.badRequest().body("El libro indicado no se encuentra registrado");
        }
        LibroEntity libro = lib.get();
        if (libro.isLibEspalindrome()) {
            return ResponseEntity.badRequest().body("los libros palíndromos solo se pueden utilizar en la biblioteca");
        }
        if (libro.getTotalEjemplaresDisponibles() <= 0) {
            return ResponseEntity.badRequest().body("El libro indicado no tiene disponibilidad");
        }
        PrestamoEntity pres = new PrestamoEntity();
        pres.setLibId(libro);
        pres.setPresNombrepersona(prestamo.getPersona());
        pres.setPresFechaprestamo(new Date());
        if (libro.isLibEsconlimite()) {
            pres.setPresFechalimite(Utilidades.addDays(pres.getPresFechaprestamo(), 15));
        }
        prestamoRepository.save(pres);
        
        libro.setTotalEjemplaresDisponibles(libro.getTotalEjemplaresDisponibles() - 1);
        libro.setTotalEjemplaresPrestados(libro.getTotalEjemplaresPrestados() + 1);
        
        libroRepository.save(libro);
        
        PrestamoOutDto salida = new PrestamoOutDto();
        salida.setEstado("OK");
        salida.setMensaje("prestamo registrado correctamente");
        return ResponseEntity.ok(salida);
        
    }
    
}
