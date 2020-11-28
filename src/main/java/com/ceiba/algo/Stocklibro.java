/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.algo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "stocklibro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stocklibro.findAll", query = "SELECT s FROM Stocklibro s"),
    @NamedQuery(name = "Stocklibro.findByStlId", query = "SELECT s FROM Stocklibro s WHERE s.stlId = :stlId"),
    @NamedQuery(name = "Stocklibro.findByStlTotal", query = "SELECT s FROM Stocklibro s WHERE s.stlTotal = :stlTotal"),
    @NamedQuery(name = "Stocklibro.findByStlDisponible", query = "SELECT s FROM Stocklibro s WHERE s.stlDisponible = :stlDisponible"),
    @NamedQuery(name = "Stocklibro.findBySolPrestados", query = "SELECT s FROM Stocklibro s WHERE s.solPrestados = :solPrestados")})
public class Stocklibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stl_id")
    private Long stlId;
    @Basic(optional = false)
    @Column(name = "stl_total")
    private long stlTotal;
    @Basic(optional = false)
    @Column(name = "stl_disponible")
    private long stlDisponible;
    @Basic(optional = false)
    @Column(name = "sol_prestados")
    private long solPrestados;
    @JoinColumn(name = "lib_id", referencedColumnName = "lib_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Libro libId;
    @JoinColumn(name = "sto_id", referencedColumnName = "sto_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stock stoId;

    public Stocklibro() {
    }

    public Stocklibro(Long stlId) {
        this.stlId = stlId;
    }

    public Stocklibro(Long stlId, long stlTotal, long stlDisponible, long solPrestados) {
        this.stlId = stlId;
        this.stlTotal = stlTotal;
        this.stlDisponible = stlDisponible;
        this.solPrestados = solPrestados;
    }

    public Long getStlId() {
        return stlId;
    }

    public void setStlId(Long stlId) {
        this.stlId = stlId;
    }

    public long getStlTotal() {
        return stlTotal;
    }

    public void setStlTotal(long stlTotal) {
        this.stlTotal = stlTotal;
    }

    public long getStlDisponible() {
        return stlDisponible;
    }

    public void setStlDisponible(long stlDisponible) {
        this.stlDisponible = stlDisponible;
    }

    public long getSolPrestados() {
        return solPrestados;
    }

    public void setSolPrestados(long solPrestados) {
        this.solPrestados = solPrestados;
    }

    public Libro getLibId() {
        return libId;
    }

    public void setLibId(Libro libId) {
        this.libId = libId;
    }

    public Stock getStoId() {
        return stoId;
    }

    public void setStoId(Stock stoId) {
        this.stoId = stoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stlId != null ? stlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stocklibro)) {
            return false;
        }
        Stocklibro other = (Stocklibro) object;
        if ((this.stlId == null && other.stlId != null) || (this.stlId != null && !this.stlId.equals(other.stlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceiba.algo.Stocklibro[ stlId=" + stlId + " ]";
    }
    
}
