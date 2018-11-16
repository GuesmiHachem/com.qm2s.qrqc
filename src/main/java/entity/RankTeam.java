/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hachem
 */
@Entity
@Table(name = "rank_team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RankTeam.findAll", query = "SELECT r FROM RankTeam r")
    , @NamedQuery(name = "RankTeam.findById", query = "SELECT r FROM RankTeam r WHERE r.id = :id")
    , @NamedQuery(name = "RankTeam.findByName", query = "SELECT r FROM RankTeam r WHERE r.name = :name")
    , @NamedQuery(name = "RankTeam.findByStartTime", query = "SELECT r FROM RankTeam r WHERE r.startTime = :startTime")
    , @NamedQuery(name = "RankTeam.findByEndTime", query = "SELECT r FROM RankTeam r WHERE r.endTime = :endTime")})
public class RankTeam implements Serializable {

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
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRankTeam")
    private List<Level0> level0List;

    public RankTeam() {
    }

    public RankTeam(Integer id) {
        this.id = id;
    }

    public RankTeam(Integer id, String name, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public List<Level0> getLevel0List() {
        return level0List;
    }

    public void setLevel0List(List<Level0> level0List) {
        this.level0List = level0List;
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
        if (!(object instanceof RankTeam)) {
            return false;
        }
        RankTeam other = (RankTeam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RankTeam[ id=" + id + " ]";
    }
    
}
