/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author gustavo
 */
@Entity
@Data
@Table(name = "prestamo")
@XmlRootElement
public class PrestamoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pres_id")
    private Long presId;
    @Basic(optional = false)
    @Column(name = "pres_nombrepersona")
    private String presNombrepersona;
    @Basic(optional = false)
    @Column(name = "pres_fechaprestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechaprestamo;
    @Column(name = "pres_fechalimite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presFechalimite;
    @JoinColumn(name = "lib_id", referencedColumnName = "lib_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LibroEntity libId;

    public PrestamoEntity() {
    }

    public PrestamoEntity(Long presId) {
        this.presId = presId;
    }

    public PrestamoEntity(Long presId, String presNombrepersona, Date presFechaprestamo) {
        this.presId = presId;
        this.presNombrepersona = presNombrepersona;
        this.presFechaprestamo = presFechaprestamo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presId != null ? presId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoEntity)) {
            return false;
        }
        PrestamoEntity other = (PrestamoEntity) object;
        if ((this.presId == null && other.presId != null) || (this.presId != null && !this.presId.equals(other.presId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceiba.algo.Prestamo[ presId=" + presId + " ]";
    }
    
}
