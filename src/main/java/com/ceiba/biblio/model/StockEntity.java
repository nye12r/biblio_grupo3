/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.model;

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
import lombok.Data;

/**
 *
 * @author gustavo
 */
@Entity
@Data
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByStoId", query = "SELECT s FROM Stock s WHERE s.stoId = :stoId"),
    @NamedQuery(name = "Stock.findByStoTotal", query = "SELECT s FROM Stock s WHERE s.stoTotal = :stoTotal"),
    @NamedQuery(name = "Stock.findByStoDisponible", query = "SELECT s FROM Stock s WHERE s.stoDisponible = :stoDisponible"),
    @NamedQuery(name = "Stock.findByStoPrestados", query = "SELECT s FROM Stock s WHERE s.stoPrestados = :stoPrestados")})
public class StockEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sto_id")
    private Long stoId;
    @Basic(optional = false)
    @Column(name = "sto_total")
    private long stoTotal;
    @Basic(optional = false)
    @Column(name = "sto_disponible")
    private long stoDisponible;
    @Basic(optional = false)
    @Column(name = "sto_prestados")
    private long stoPrestados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stoId", fetch = FetchType.LAZY)
    private List<StocklibroEntity> stocklibroList;

    public StockEntity() {
    }

    public StockEntity(Long stoId) {
        this.stoId = stoId;
    }

    public StockEntity(Long stoId, long stoTotal, long stoDisponible, long stoPrestados) {
        this.stoId = stoId;
        this.stoTotal = stoTotal;
        this.stoDisponible = stoDisponible;
        this.stoPrestados = stoPrestados;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stoId != null ? stoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockEntity)) {
            return false;
        }
        StockEntity other = (StockEntity) object;
        if ((this.stoId == null && other.stoId != null) || (this.stoId != null && !this.stoId.equals(other.stoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceiba.algo.Stock[ stoId=" + stoId + " ]";
    }
    
}
