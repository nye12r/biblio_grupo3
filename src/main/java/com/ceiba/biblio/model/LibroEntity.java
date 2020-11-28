package com.ceiba.biblio.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity(name = "Libro")
@Data
@NamedQuery(name = "Libro.findByIsbn", query = "SELECT libro FROM Libro libro WHERE libro.isbn = :isbn")
public class LibroEntity  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lib_id")
    private Long id;

    @Column(nullable = false, name = "lib_nombre")
    private String titulo;

    @Column(nullable = false, name = "lib_isbn")
    private String isbn;

    @Basic(optional = false)
    @Column(name = "lib_espalindrome")
    private boolean libEspalindrome;
    @Basic(optional = false)
    @Column(name = "lib_esconlimite")
    private boolean libEsconlimite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libId", fetch = FetchType.LAZY)
    private List<PrestamoEntity> prestamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libId", fetch = FetchType.LAZY)
    private List<StockLibroEntity> stocklibroList;
}
