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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hachem
 */
@Entity
@Table(name = "step1_action_followed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step1ActionFollowed.findAll", query = "SELECT s FROM Step1ActionFollowed s")
    , @NamedQuery(name = "Step1ActionFollowed.findById", query = "SELECT s FROM Step1ActionFollowed s WHERE s.id = :id")
    , @NamedQuery(name = "Step1ActionFollowed.findByEffective", query = "SELECT s FROM Step1ActionFollowed s WHERE s.effective = :effective")
    , @NamedQuery(name = "Step1ActionFollowed.findByToBeFollowed", query = "SELECT s FROM Step1ActionFollowed s WHERE s.toBeFollowed = :toBeFollowed")
    , @NamedQuery(name = "Step1ActionFollowed.findByDateCreation", query = "SELECT s FROM Step1ActionFollowed s WHERE s.dateCreation = :dateCreation")})
public class Step1ActionFollowed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "effective")
    private boolean effective;
    @Basic(optional = false)
    @NotNull
    @Column(name = "toBeFollowed")
    private boolean toBeFollowed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "id_level0", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Level0 idLevel0;
    @JoinColumn(name = "id_step1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Step1 idStep1;

    public Step1ActionFollowed() {
    }

    public Step1ActionFollowed(Integer id) {
        this.id = id;
    }

    public Step1ActionFollowed(Integer id, boolean effective, boolean toBeFollowed, Date dateCreation) {
        this.id = id;
        this.effective = effective;
        this.toBeFollowed = toBeFollowed;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEffective() {
        return effective;
    }

    public void setEffective(boolean effective) {
        this.effective = effective;
    }

    public boolean getToBeFollowed() {
        return toBeFollowed;
    }

    public void setToBeFollowed(boolean toBeFollowed) {
        this.toBeFollowed = toBeFollowed;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Level0 getIdLevel0() {
        return idLevel0;
    }

    public void setIdLevel0(Level0 idLevel0) {
        this.idLevel0 = idLevel0;
    }

    public Step1 getIdStep1() {
        return idStep1;
    }

    public void setIdStep1(Step1 idStep1) {
        this.idStep1 = idStep1;
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
        if (!(object instanceof Step1ActionFollowed)) {
            return false;
        }
        Step1ActionFollowed other = (Step1ActionFollowed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Step1ActionFollowed[ id=" + id + " ]";
    }
    
}
