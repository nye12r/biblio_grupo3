/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.test;

import com.ceiba.biblio.dto.LibroInDto;
import com.ceiba.biblio.dto.PrestamoInDto;
import com.ceiba.biblio.dto.Utilidades;
import com.ceiba.biblio.service.LibroService;
import com.ceiba.biblio.service.PrestamoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author gustavo
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PrestamoTest {

    @Autowired
    private PrestamoService prestamoService;
    @Autowired
    private LibroService libroService;

    // @Test
    public void probarFechas() {
        Utilidades.addDays(new Date(), 15);
    }

    @Test
    @Rollback(false)
    public void probarPrestamo() {

        //Caso se presta un libro con disponibilidad
        addLibro("a1", "algo");
        addPrestamo("a1", "yo");

        //Caso se presta un libro con disponibilidad palindrome
        addLibro("oso", "algo");
        addPrestamo("oso", "yo");

        //Caso se presta un libro sin disponibilidad
        addPrestamo("a1", "yo");

    }

    private void addLibro(String isbn, String nombre) {
        LibroInDto libroIn = new LibroInDto();
        libroIn.setIsbn(isbn);
        libroIn.setNombreLibro(nombre);
        ResponseEntity salida = libroService.crearLibro(libroIn);
        System.out.println("mensaje: " + salida.getBody().toString());
    }

    private void addPrestamo(String isbn, String persona) {
        PrestamoInDto prestamo = new PrestamoInDto();
        prestamo.setIsbn(isbn);
        prestamo.setPersona(persona);
        ResponseEntity salida = prestamoService.prestarLibro(prestamo);
        System.out.println("mensaje: " + salida.getBody().toString());
    }

    @TestConfiguration
    static class ContextConfiguration {

        @Bean
        public LibroService libroService() {
            return new LibroService();
        }

        @Bean
        public PrestamoService prestamoService() {
            return new PrestamoService();
        }
    }

}
