/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hachem
 */
@Entity
@Table(name = "level2_relation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level2Relation.findAll", query = "SELECT l FROM Level2Relation l")
    , @NamedQuery(name = "Level2Relation.findById", query = "SELECT l FROM Level2Relation l WHERE l.id = :id")})
public class Level2Relation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_level2_p1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level2 idLevel2P1;
    @JoinColumn(name = "id_level2_p2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level2 idLevel2P2;

    public Level2Relation() {
    }

    public Level2Relation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Level2 getIdLevel2P1() {
        return idLevel2P1;
    }

    public void setIdLevel2P1(Level2 idLevel2P1) {
        this.idLevel2P1 = idLevel2P1;
    }

    public Level2 getIdLevel2P2() {
        return idLevel2P2;
    }

    public void setIdLevel2P2(Level2 idLevel2P2) {
        this.idLevel2P2 = idLevel2P2;
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
        if (!(object instanceof Level2Relation)) {
            return false;
        }
        Level2Relation other = (Level2Relation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Level2Relation[ id=" + id + " ]";
    }
    
}
