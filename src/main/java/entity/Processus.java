/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
 * @author Hachem
 */
@Entity
@Table(name = "processus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processus.findAll", query = "SELECT p FROM Processus p")
    , @NamedQuery(name = "Processus.findById", query = "SELECT p FROM Processus p WHERE p.id = :id")
    , @NamedQuery(name = "Processus.findByName", query = "SELECT p FROM Processus p WHERE p.name = :name")})
public class Processus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id_nature", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nature idNature;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private User idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcessus")
    private List<Level2> level2List;

    public Processus() {
    }

    public Processus(Integer id) {
        this.id = id;
    }

    public Processus(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Nature getIdNature() {
        return idNature;
    }

    public void setIdNature(Nature idNature) {
        this.idNature = idNature;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<Level2> getLevel2List() {
        return level2List;
    }

    public void setLevel2List(List<Level2> level2List) {
        this.level2List = level2List;
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
        if (!(object instanceof Processus)) {
            return false;
        }
        Processus other = (Processus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Processus[ id=" + id + " ]";
    }
    
}
