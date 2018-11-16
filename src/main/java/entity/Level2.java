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
@Table(name = "level2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level2.findAll", query = "SELECT l FROM Level2 l")
    , @NamedQuery(name = "Level2.findById", query = "SELECT l FROM Level2 l WHERE l.id = :id")
    , @NamedQuery(name = "Level2.findByName", query = "SELECT l FROM Level2 l WHERE l.name = :name")})
public class Level2 implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel2P1")
    private List<Level2Relation> level2RelationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel2P2")
    private List<Level2Relation> level2RelationList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel2")
    private List<Level1> level1List;
    @OneToMany(mappedBy = "idLevel2")
    private List<User> userList;
    @JoinColumn(name = "id_level3", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level3 idLevel3;
    @JoinColumn(name = "id_processus", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Processus idProcessus;

    public Level2() {
    }

    public Level2(Integer id) {
        this.id = id;
    }

    public Level2(Integer id, String name) {
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

    @XmlTransient
    public List<Level2Relation> getLevel2RelationList() {
        return level2RelationList;
    }

    public void setLevel2RelationList(List<Level2Relation> level2RelationList) {
        this.level2RelationList = level2RelationList;
    }

    @XmlTransient
    public List<Level2Relation> getLevel2RelationList1() {
        return level2RelationList1;
    }

    public void setLevel2RelationList1(List<Level2Relation> level2RelationList1) {
        this.level2RelationList1 = level2RelationList1;
    }

    @XmlTransient
    public List<Level1> getLevel1List() {
        return level1List;
    }

    public void setLevel1List(List<Level1> level1List) {
        this.level1List = level1List;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Level3 getIdLevel3() {
        return idLevel3;
    }

    public void setIdLevel3(Level3 idLevel3) {
        this.idLevel3 = idLevel3;
    }

    public Processus getIdProcessus() {
        return idProcessus;
    }

    public void setIdProcessus(Processus idProcessus) {
        this.idProcessus = idProcessus;
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
        if (!(object instanceof Level2)) {
            return false;
        }
        Level2 other = (Level2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Level2[ id=" + id + " ]";
    }
    
}
