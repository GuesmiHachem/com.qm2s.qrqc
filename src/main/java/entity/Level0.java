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
@Table(name = "level0")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level0.findAll", query = "SELECT l FROM Level0 l")
    , @NamedQuery(name = "Level0.findById", query = "SELECT l FROM Level0 l WHERE l.id = :id")
    , @NamedQuery(name = "Level0.findByName", query = "SELECT l FROM Level0 l WHERE l.name = :name")})
public class Level0 implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLevel0")
    private List<Step1ActionFollowed> step1ActionFollowedList;
    @JoinColumn(name = "id_level1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level1 idLevel1;
    @JoinColumn(name = "id_rank_team", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RankTeam idRankTeam;
    @OneToMany(mappedBy = "idLevel0")
    private List<User> userList;

    public Level0() {
    }

    public Level0(Integer id) {
        this.id = id;
    }

    public Level0(Integer id, String name) {
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
    public List<Step1ActionFollowed> getStep1ActionFollowedList() {
        return step1ActionFollowedList;
    }

    public void setStep1ActionFollowedList(List<Step1ActionFollowed> step1ActionFollowedList) {
        this.step1ActionFollowedList = step1ActionFollowedList;
    }

    public Level1 getIdLevel1() {
        return idLevel1;
    }

    public void setIdLevel1(Level1 idLevel1) {
        this.idLevel1 = idLevel1;
    }

    public RankTeam getIdRankTeam() {
        return idRankTeam;
    }

    public void setIdRankTeam(RankTeam idRankTeam) {
        this.idRankTeam = idRankTeam;
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
        if (!(object instanceof Level0)) {
            return false;
        }
        Level0 other = (Level0) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Level0[ id=" + id + " ]";
    }
    
}
