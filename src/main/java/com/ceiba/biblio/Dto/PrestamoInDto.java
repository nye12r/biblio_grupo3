/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.Dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author gustavo
 */
@Data
@ToString
public class PrestamoInDto implements Serializable {

    private String persona;
    private String isbn;

}
