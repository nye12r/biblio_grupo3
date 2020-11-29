/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.controller;

import com.ceiba.biblio.Dto.PrestamoInDto;
import com.ceiba.biblio.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gustavo
 */
@RestController
@CrossOrigin(origins = "*")
@Controller
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/prestar")
    public ResponseEntity prestarLibro(@RequestBody PrestamoInDto prestamo) {
        return prestamoService.prestarLibro(prestamo);
    }

}
