/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.algo;

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

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByPresId", query = "SELECT p FROM Prestamo p WHERE p.presId = :presId"),
    @NamedQuery(name = "Prestamo.findByPresNombrepersona", query = "SELECT p FROM Prestamo p WHERE p.presNombrepersona = :presNombrepersona"),
    @NamedQuery(name = "Prestamo.findByPresFechaprestamo", query = "SELECT p FROM Prestamo p WHERE p.presFechaprestamo = :presFechaprestamo"),
    @NamedQuery(name = "Prestamo.findByPresFechalimite", query = "SELECT p FROM Prestamo p WHERE p.presFechalimite = :presFechalimite")})
public class Prestamo implements Serializable {

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
    private Libro libId;

    public Prestamo() {
    }

    public Prestamo(Long presId) {
        this.presId = presId;
    }

    public Prestamo(Long presId, String presNombrepersona, Date presFechaprestamo) {
        this.presId = presId;
        this.presNombrepersona = presNombrepersona;
        this.presFechaprestamo = presFechaprestamo;
    }

    public Long getPresId() {
        return presId;
    }

    public void setPresId(Long presId) {
        this.presId = presId;
    }

    public String getPresNombrepersona() {
        return presNombrepersona;
    }

    public void setPresNombrepersona(String presNombrepersona) {
        this.presNombrepersona = presNombrepersona;
    }

    public Date getPresFechaprestamo() {
        return presFechaprestamo;
    }

    public void setPresFechaprestamo(Date presFechaprestamo) {
        this.presFechaprestamo = presFechaprestamo;
    }

    public Date getPresFechalimite() {
        return presFechalimite;
    }

    public void setPresFechalimite(Date presFechalimite) {
        this.presFechalimite = presFechalimite;
    }

    public Libro getLibId() {
        return libId;
    }

    public void setLibId(Libro libId) {
        this.libId = libId;
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
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
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
