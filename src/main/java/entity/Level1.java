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
@Table(name = "level1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level1.findAll", query = "SELECT l FROM Level1 l")
    , @NamedQuery(name = "Level1.findById", query = "SELECT l FROM Level1 l WHERE l.id = :id")
    , @NamedQuery(name = "Level1.findByName", query = "SELECT l FROM Level1 l WHERE l.name = :name")})
public class Level1 implements Serializable {

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
    @OneToMany(mappedBy = "idLevel1")
    private List<Problem> problemList;
    @JoinColumn(name = "id_level2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level2 idLevel2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel1")
    private List<Level0> level0List;
    @OneToMany(mappedBy = "idLevel1")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel1")
    private List<Hardware> hardwareList;

    public Level1() {
    }

    public Level1(Integer id) {
        this.id = id;
    }

    public Level1(Integer id, String name) {
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
    public List<Problem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }

    public Level2 getIdLevel2() {
        return idLevel2;
    }

    public void setIdLevel2(Level2 idLevel2) {
        this.idLevel2 = idLevel2;
    }

    @XmlTransient
    public List<Level0> getLevel0List() {
        return level0List;
    }

    public void setLevel0List(List<Level0> level0List) {
        this.level0List = level0List;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Hardware> getHardwareList() {
        return hardwareList;
    }

    public void setHardwareList(List<Hardware> hardwareList) {
        this.hardwareList = hardwareList;
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
        if (!(object instanceof Level1)) {
            return false;
        }
        Level1 other = (Level1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Level1[ id=" + id + " ]";
    }
    
}
