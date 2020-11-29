/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.Dto;


import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author angie.jaramillo
 */

@Data
@ToString
public class ListaLibroOutDto {
    private String isbn;
    private String nombreLibro;
    private String nombrePersona;
    private Date fechaLimite;
}
