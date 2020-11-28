package com.ceiba.biblio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity(name = "Libro")
@Data
public class LibroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lib_id")
    private Long id;

    @Column(nullable = false, name = "lib_nombre")
    private String titulo;

    @Column(nullable = false, name = "lib_isbn")
    private String isbn;

    @Column(nullable = false, name = "total_ejemplares")
    private Long totalEjemplares;

    @Column(nullable = false, name = "total_ejemplares_disponibles")
    private Long totalEjemplaresDisponibles;

    @Column(nullable = false, name = "total_ejemplares_prestado")
    private Long totalEjemplaresPrestados;

    @Basic(optional = false)
    @Column(name = "lib_espalindrome")
    private boolean libEspalindrome;
    @Basic(optional = false)
    @Column(name = "lib_esconlimite")
    private boolean libEsconlimite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libId", fetch = FetchType.LAZY)
    private List<PrestamoEntity> prestamoList;
}
