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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hachem
 */
@Entity
@Table(name = "step1_securisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step1Securisation.findAll", query = "SELECT s FROM Step1Securisation s")
    , @NamedQuery(name = "Step1Securisation.findById", query = "SELECT s FROM Step1Securisation s WHERE s.id = :id")
    , @NamedQuery(name = "Step1Securisation.findByAction", query = "SELECT s FROM Step1Securisation s WHERE s.action = :action")
    , @NamedQuery(name = "Step1Securisation.findByPriority", query = "SELECT s FROM Step1Securisation s WHERE s.priority = :priority")
    , @NamedQuery(name = "Step1Securisation.findByState", query = "SELECT s FROM Step1Securisation s WHERE s.state = :state")
    , @NamedQuery(name = "Step1Securisation.findByPercentageCompleted", query = "SELECT s FROM Step1Securisation s WHERE s.percentageCompleted = :percentageCompleted")
    , @NamedQuery(name = "Step1Securisation.findByStartDate", query = "SELECT s FROM Step1Securisation s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "Step1Securisation.findByDeadline", query = "SELECT s FROM Step1Securisation s WHERE s.deadline = :deadline")
    , @NamedQuery(name = "Step1Securisation.findByWhere", query = "SELECT s FROM Step1Securisation s WHERE s.where = :where")
    , @NamedQuery(name = "Step1Securisation.findByHowMutch", query = "SELECT s FROM Step1Securisation s WHERE s.howMutch = :howMutch")
    , @NamedQuery(name = "Step1Securisation.findByResult", query = "SELECT s FROM Step1Securisation s WHERE s.result = :result")})
public class Step1Securisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentage_completed")
    private int percentageCompleted;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "where_")
    private String where;
    @Basic(optional = false)
    @NotNull
    @Column(name = "how_mutch")
    private int howMutch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result")
    private int result;
    @JoinColumn(name = "id_step1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Step1 idStep1;
    @JoinColumn(name = "affected_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User affectedTo;

    public Step1Securisation() {
    }

    public Step1Securisation(Integer id) {
        this.id = id;
    }

    public Step1Securisation(Integer id, String action, String priority, String state, int percentageCompleted, String description, Date startDate, Date deadline, String where, int howMutch, int result) {
        this.id = id;
        this.action = action;
        this.priority = priority;
        this.state = state;
        this.percentageCompleted = percentageCompleted;
        this.description = description;
        this.startDate = startDate;
        this.deadline = deadline;
        this.where = where;
        this.howMutch = howMutch;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(int percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public int getHowMutch() {
        return howMutch;
    }

    public void setHowMutch(int howMutch) {
        this.howMutch = howMutch;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Step1 getIdStep1() {
        return idStep1;
    }

    public void setIdStep1(Step1 idStep1) {
        this.idStep1 = idStep1;
    }

    public User getAffectedTo() {
        return affectedTo;
    }

    public void setAffectedTo(User affectedTo) {
        this.affectedTo = affectedTo;
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
        if (!(object instanceof Step1Securisation)) {
            return false;
        }
        Step1Securisation other = (Step1Securisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Step1Securisation[ id=" + id + " ]";
    }
    
}
