/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.Dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author gustavo
 */
@Data
@ToString
public class PrestamoInDto implements Serializable {

    private String persona;
    private String isbn;

}
