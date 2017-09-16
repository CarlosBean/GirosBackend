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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadEmisor")
    private List<Giros> girosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadReceptor")
    private List<Giros> girosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadesId")
    private List<Clientes> clientesList;
    @JoinColumn(name = "departamentos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departamentos departamentosId;

    public Ciudades() {
    }

    public Ciudades(Integer id) {
        this.id = id;
    }

    public Ciudades(Integer id, String ciudad) {
        this.id = id;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public Departamentos getDepartamentosId() {
        return departamentosId;
    }

    public void setDepartamentosId(Departamentos departamentosId) {
        this.departamentosId = departamentosId;
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
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.girosSAS.jpa.entities.Ciudades[ id=" + id + " ]";
    }
    
}
