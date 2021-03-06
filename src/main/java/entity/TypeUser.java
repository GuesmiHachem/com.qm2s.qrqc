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
@Table(name = "type_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeUser.findAll", query = "SELECT t FROM TypeUser t")
    , @NamedQuery(name = "TypeUser.findById", query = "SELECT t FROM TypeUser t WHERE t.id = :id")
    , @NamedQuery(name = "TypeUser.findByName", query = "SELECT t FROM TypeUser t WHERE t.name = :name")})
public class TypeUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeUser")
    private List<Step1AlertCan> step1AlertCanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeUser")
    private List<Step1AlertShould> step1AlertShouldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeUser")
    private List<User> userList;

    public TypeUser() {
    }

    public TypeUser(Integer id) {
        this.id = id;
    }

    public TypeUser(Integer id, String name) {
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
    public List<Step1AlertCan> getStep1AlertCanList() {
        return step1AlertCanList;
    }

    public void setStep1AlertCanList(List<Step1AlertCan> step1AlertCanList) {
        this.step1AlertCanList = step1AlertCanList;
    }

    @XmlTransient
    public List<Step1AlertShould> getStep1AlertShouldList() {
        return step1AlertShouldList;
    }

    public void setStep1AlertShouldList(List<Step1AlertShould> step1AlertShouldList) {
        this.step1AlertShouldList = step1AlertShouldList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        if (!(object instanceof TypeUser)) {
            return false;
        }
        TypeUser other = (TypeUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypeUser[ id=" + id + " ]";
    }
    
}
