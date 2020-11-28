/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.model;

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
import lombok.Data;

/**
 *
 * @author gustavo
 */
@Entity
@Data
@Table(name = "stocklibro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stocklibro.findAll", query = "SELECT s FROM Stocklibro s"),
    @NamedQuery(name = "Stocklibro.findByStlId", query = "SELECT s FROM Stocklibro s WHERE s.stlId = :stlId"),
    @NamedQuery(name = "Stocklibro.findByStlTotal", query = "SELECT s FROM Stocklibro s WHERE s.stlTotal = :stlTotal"),
    @NamedQuery(name = "Stocklibro.findByStlDisponible", query = "SELECT s FROM Stocklibro s WHERE s.stlDisponible = :stlDisponible"),
    @NamedQuery(name = "Stocklibro.findBySolPrestados", query = "SELECT s FROM Stocklibro s WHERE s.solPrestados = :solPrestados")})
public class StockLibroEntity implements Serializable {

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
    private LibroEntity libId;
    @JoinColumn(name = "sto_id", referencedColumnName = "sto_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StockEntity stoId;

    public StockLibroEntity() {
    }

    public StockLibroEntity(Long stlId) {
        this.stlId = stlId;
    }

    public StockLibroEntity(Long stlId, long stlTotal, long stlDisponible, long solPrestados) {
        this.stlId = stlId;
        this.stlTotal = stlTotal;
        this.stlDisponible = stlDisponible;
        this.solPrestados = solPrestados;
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
        if (!(object instanceof StockLibroEntity)) {
            return false;
        }
        StockLibroEntity other = (StockLibroEntity) object;
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
