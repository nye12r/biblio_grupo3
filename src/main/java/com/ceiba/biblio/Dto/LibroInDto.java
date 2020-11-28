package com.ceiba.biblio.Dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class LibroInDto implements Serializable {
    private String isbn;
    private String nombreLibro;
}

