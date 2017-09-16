/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author ADMIN
 */
@Entity
@Table(name = "giros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giros.findAll", query = "SELECT g FROM Giros g")})
public class Giros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado")
    private Boolean estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "id_ciudad_emisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudadEmisor;
    @JoinColumn(name = "id_ciudad_receptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudadReceptor;
    @JoinColumn(name = "id_emisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idEmisor;
    @JoinColumn(name = "id_receptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idReceptor;

    public Giros() {
    }

    public Giros(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Ciudades getIdCiudadEmisor() {
        return idCiudadEmisor;
    }

    public void setIdCiudadEmisor(Ciudades idCiudadEmisor) {
        this.idCiudadEmisor = idCiudadEmisor;
    }

    public Ciudades getIdCiudadReceptor() {
        return idCiudadReceptor;
    }

    public void setIdCiudadReceptor(Ciudades idCiudadReceptor) {
        this.idCiudadReceptor = idCiudadReceptor;
    }

    public Clientes getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Clientes idEmisor) {
        this.idEmisor = idEmisor;
    }

    public Clientes getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Clientes idReceptor) {
        this.idReceptor = idReceptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giros)) {
            return false;
        }
        Giros other = (Giros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.girosSAS.jpa.entities.Giros[ id=" + id + " ]";
    }
    
}
