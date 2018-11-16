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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problem.findAll", query = "SELECT p FROM Problem p")
    , @NamedQuery(name = "Problem.findById", query = "SELECT p FROM Problem p WHERE p.id = :id")
    , @NamedQuery(name = "Problem.findByCode", query = "SELECT p FROM Problem p WHERE p.code = :code")
    , @NamedQuery(name = "Problem.findByReference", query = "SELECT p FROM Problem p WHERE p.reference = :reference")
    , @NamedQuery(name = "Problem.findByStatus", query = "SELECT p FROM Problem p WHERE p.status = :status")
    , @NamedQuery(name = "Problem.findByLevel", query = "SELECT p FROM Problem p WHERE p.level = :level")
    , @NamedQuery(name = "Problem.findByDateCreation", query = "SELECT p FROM Problem p WHERE p.dateCreation = :dateCreation")})
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "code")
    private String code;
    @Size(max = 30)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "status")
    private String status;
    @Column(name = "level")
    private Integer level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(mappedBy = "idProblem")
    private List<Step1> step1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProblem")
    private List<Notification> notificationList;
    @JoinColumn(name = "id_step1", referencedColumnName = "id")
    @ManyToOne
    private Step1 idStep1;
    @JoinColumn(name = "id_type_problem", referencedColumnName = "id")
    @ManyToOne
    private TypeProblem idTypeProblem;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private User idUser;
    @JoinColumn(name = "id_level1", referencedColumnName = "id")
    @ManyToOne
    private Level1 idLevel1;

    public Problem() {
    }

    public Problem(Integer id) {
        this.id = id;
    }

    public Problem(Integer id, String code, String status, Date dateCreation) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @XmlTransient
    public List<Step1> getStep1List() {
        return step1List;
    }

    public void setStep1List(List<Step1> step1List) {
        this.step1List = step1List;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public Step1 getIdStep1() {
        return idStep1;
    }

    public void setIdStep1(Step1 idStep1) {
        this.idStep1 = idStep1;
    }

    public TypeProblem getIdTypeProblem() {
        return idTypeProblem;
    }

    public void setIdTypeProblem(TypeProblem idTypeProblem) {
        this.idTypeProblem = idTypeProblem;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Level1 getIdLevel1() {
        return idLevel1;
    }

    public void setIdLevel1(Level1 idLevel1) {
        this.idLevel1 = idLevel1;
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
        if (!(object instanceof Problem)) {
            return false;
        }
        Problem other = (Problem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Problem[ id=" + id + " ]";
    }
    
}
