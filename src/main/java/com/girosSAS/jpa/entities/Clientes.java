/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_documento")
    private String numDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmisor")
    private List<Giros> girosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReceptor")
    private List<Giros> girosList1;
    @JoinColumn(name = "ciudades_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades ciudadesId;

    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, String numDocumento, String nombres) {
        this.id = id;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @XmlTransient
    public List<Giros> getGirosList() {
        return girosList;
    }

    public void setGirosList(List<Giros> girosList) {
        this.girosList = girosList;
    }

    @XmlTransient
    public List<Giros> getGirosList1() {
        return girosList1;
    }

    public void setGirosList1(List<Giros> girosList1) {
        this.girosList1 = girosList1;
    }

    public Ciudades getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(Ciudades ciudadesId) {
        this.ciudadesId = ciudadesId;
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
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.girosSAS.jpa.entities.Clientes[ id=" + id + " ]";
    }
    
}
