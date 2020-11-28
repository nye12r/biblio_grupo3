package com.cieba.biblio.model;
import javax.persistence.*;

@Entity(name = "Libro")
@NamedQuery(name = "Libro.findByIsbn", query = "SELECT libro FROM Libro libro WHERE libro.isbn = :isbn")
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Integer anio;
}
