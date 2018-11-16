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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hachem
 */
@Entity
@Table(name = "step1_why")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step1Why.findAll", query = "SELECT s FROM Step1Why s")
    , @NamedQuery(name = "Step1Why.findById", query = "SELECT s FROM Step1Why s WHERE s.id = :id")
    , @NamedQuery(name = "Step1Why.findByWhy", query = "SELECT s FROM Step1Why s WHERE s.why = :why")})
public class Step1Why implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "why_")
    private String why;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "id_step1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Step1 idStep1;

    public Step1Why() {
    }

    public Step1Why(Integer id) {
        this.id = id;
    }

    public Step1Why(Integer id, String why, String comment) {
        this.id = id;
        this.why = why;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof Step1Why)) {
            return false;
        }
        Step1Why other = (Step1Why) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Step1Why[ id=" + id + " ]";
    }
    
}
