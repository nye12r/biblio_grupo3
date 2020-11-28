/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.algo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByLibId", query = "SELECT l FROM Libro l WHERE l.libId = :libId"),
    @NamedQuery(name = "Libro.findByLibIsbn", query = "SELECT l FROM Libro l WHERE l.libIsbn = :libIsbn"),
    @NamedQuery(name = "Libro.findByLibNombre", query = "SELECT l FROM Libro l WHERE l.libNombre = :libNombre"),
    @NamedQuery(name = "Libro.findByLibEspalindrome", query = "SELECT l FROM Libro l WHERE l.libEspalindrome = :libEspalindrome"),
    @NamedQuery(name = "Libro.findByLibEsconlimite", query = "SELECT l FROM Libro l WHERE l.libEsconlimite = :libEsconlimite")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lib_id")
    private Long libId;
    @Basic(optional = false)
    @Column(name = "lib_isbn")
    private String libIsbn;
    @Basic(optional = false)
    @Column(name = "lib_nombre")
    private String libNombre;
    @Basic(optional = false)
    @Column(name = "lib_espalindrome")
    private boolean libEspalindrome;
    @Basic(optional = false)
    @Column(name = "lib_esconlimite")
    private boolean libEsconlimite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libId", fetch = FetchType.LAZY)
    private List<Prestamo> prestamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libId", fetch = FetchType.LAZY)
    private List<Stocklibro> stocklibroList;

    public Libro() {
    }

    public Libro(Long libId) {
        this.libId = libId;
    }

    public Libro(Long libId, String libIsbn, String libNombre, boolean libEspalindrome, boolean libEsconlimite) {
        this.libId = libId;
        this.libIsbn = libIsbn;
        this.libNombre = libNombre;
        this.libEspalindrome = libEspalindrome;
        this.libEsconlimite = libEsconlimite;
    }

    public Long getLibId() {
        return libId;
    }

    public void setLibId(Long libId) {
        this.libId = libId;
    }

    public String getLibIsbn() {
        return libIsbn;
    }

    public void setLibIsbn(String libIsbn) {
        this.libIsbn = libIsbn;
    }

    public String getLibNombre() {
        return libNombre;
    }

    public void setLibNombre(String libNombre) {
        this.libNombre = libNombre;
    }

    public boolean getLibEspalindrome() {
        return libEspalindrome;
    }

    public void setLibEspalindrome(boolean libEspalindrome) {
        this.libEspalindrome = libEspalindrome;
    }

    public boolean getLibEsconlimite() {
        return libEsconlimite;
    }

    public void setLibEsconlimite(boolean libEsconlimite) {
        this.libEsconlimite = libEsconlimite;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @XmlTransient
    public List<Stocklibro> getStocklibroList() {
        return stocklibroList;
    }

    public void setStocklibroList(List<Stocklibro> stocklibroList) {
        this.stocklibroList = stocklibroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libId != null ? libId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.libId == null && other.libId != null) || (this.libId != null && !this.libId.equals(other.libId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceiba.algo.Libro[ libId=" + libId + " ]";
    }
    
}
