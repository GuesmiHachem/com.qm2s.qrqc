/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hachem
 */
@Entity
@Table(name = "hardware")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hardware.findAll", query = "SELECT h FROM Hardware h")
    , @NamedQuery(name = "Hardware.findById", query = "SELECT h FROM Hardware h WHERE h.id = :id")
    , @NamedQuery(name = "Hardware.findByName", query = "SELECT h FROM Hardware h WHERE h.name = :name")
    , @NamedQuery(name = "Hardware.findByDateCreation", query = "SELECT h FROM Hardware h WHERE h.dateCreation = :dateCreation")
    , @NamedQuery(name = "Hardware.findByActive", query = "SELECT h FROM Hardware h WHERE h.active = :active")})
public class Hardware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "id_level1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level1 idLevel1;

    public Hardware() {
    }

    public Hardware(Integer id) {
        this.id = id;
    }

    public Hardware(Integer id, String name, Date dateCreation, boolean active) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Level1 getIdLevel1() {
        return idLevel1;
    }

    public void setIdLevel1(Level1 idLevel1) {
        this.idLevel1 = idLevel1;
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
        if (!(object instanceof Hardware)) {
            return false;
        }
        Hardware other = (Hardware) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hardware[ id=" + id + " ]";
    }
    
}
