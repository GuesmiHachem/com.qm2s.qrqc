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
@Table(name = "step1_alert_should")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step1AlertShould.findAll", query = "SELECT s FROM Step1AlertShould s")
    , @NamedQuery(name = "Step1AlertShould.findById", query = "SELECT s FROM Step1AlertShould s WHERE s.id = :id")})
public class Step1AlertShould implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_step1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Step1 idStep1;
    @JoinColumn(name = "id_type_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeUser idTypeUser;

    public Step1AlertShould() {
    }

    public Step1AlertShould(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Step1 getIdStep1() {
        return idStep1;
    }

    public void setIdStep1(Step1 idStep1) {
        this.idStep1 = idStep1;
    }

    public TypeUser getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(TypeUser idTypeUser) {
        this.idTypeUser = idTypeUser;
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
        if (!(object instanceof Step1AlertShould)) {
            return false;
        }
        Step1AlertShould other = (Step1AlertShould) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Step1AlertShould[ id=" + id + " ]";
    }
    
}
