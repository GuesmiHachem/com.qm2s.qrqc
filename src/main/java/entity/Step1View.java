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
@Table(name = "step1_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step1View.findAll", query = "SELECT s FROM Step1View s")
    , @NamedQuery(name = "Step1View.findById", query = "SELECT s FROM Step1View s WHERE s.id = :id")
    , @NamedQuery(name = "Step1View.findByDateCreation", query = "SELECT s FROM Step1View s WHERE s.dateCreation = :dateCreation")})
public class Step1View implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "id_step1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Step1 idStep1;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Step1View() {
    }

    public Step1View(Integer id) {
        this.id = id;
    }

    public Step1View(Integer id, Date dateCreation) {
        this.id = id;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Step1 getIdStep1() {
        return idStep1;
    }

    public void setIdStep1(Step1 idStep1) {
        this.idStep1 = idStep1;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Step1View)) {
            return false;
        }
        Step1View other = (Step1View) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Step1View[ id=" + id + " ]";
    }
    
}
