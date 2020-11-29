/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.test;

import com.ceiba.biblio.Dto.Utilidades;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gustavo
 */

public class prestamoTest {
    
    @Test
    public void probarFechas() {
        Utilidades.addDays(new Date(), 15);
    }
    
}
