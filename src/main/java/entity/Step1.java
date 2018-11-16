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
import javax.persistence.Lob;
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
@Table(name = "step1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Step1.findAll", query = "SELECT s FROM Step1 s")
    , @NamedQuery(name = "Step1.findById", query = "SELECT s FROM Step1 s WHERE s.id = :id")
    , @NamedQuery(name = "Step1.findByHowMutch", query = "SELECT s FROM Step1 s WHERE s.howMutch = :howMutch")
    , @NamedQuery(name = "Step1.findByRespectStandard", query = "SELECT s FROM Step1 s WHERE s.respectStandard = :respectStandard")
    , @NamedQuery(name = "Step1.findBySort", query = "SELECT s FROM Step1 s WHERE s.sort = :sort")
    , @NamedQuery(name = "Step1.findByStartValidation", query = "SELECT s FROM Step1 s WHERE s.startValidation = :startValidation")
    , @NamedQuery(name = "Step1.findByRecognizedProblem", query = "SELECT s FROM Step1 s WHERE s.recognizedProblem = :recognizedProblem")
    , @NamedQuery(name = "Step1.findByDateCreation", query = "SELECT s FROM Step1 s WHERE s.dateCreation = :dateCreation")
    , @NamedQuery(name = "Step1.findByDateValidation", query = "SELECT s FROM Step1 s WHERE s.dateValidation = :dateValidation")})
public class Step1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "when_")
    private String when;
    @Lob
    @Size(max = 65535)
    @Column(name = "where_")
    private String where;
    @Lob
    @Size(max = 65535)
    @Column(name = "who_")
    private String who;
    @Lob
    @Size(max = 65535)
    @Column(name = "how_")
    private String how;
    @Column(name = "how_mutch_")
    private Integer howMutch;
    @Lob
    @Size(max = 65535)
    @Column(name = "why_")
    private String why;
    @Lob
    @Size(max = 65535)
    @Column(name = "what_")
    private String what;
    @Lob
    @Size(max = 65535)
    @Column(name = "bad_piece")
    private String badPiece;
    @Lob
    @Size(max = 65535)
    @Column(name = "good_piece")
    private String goodPiece;
    @Column(name = "respect_standard")
    private Boolean respectStandard;
    @Column(name = "sort")
    private Boolean sort;
    @Lob
    @Size(max = 65535)
    @Column(name = "sort_criterion")
    private String sortCriterion;
    @Lob
    @Size(max = 65535)
    @Column(name = "immediate_actions")
    private String immediateActions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_validation")
    private boolean startValidation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recognized_problem")
    private boolean recognizedProblem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "date_validation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValidation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1Comment> step1CommentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1Action> step1ActionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1Securisation> step1SecurisationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1ActionFollowed> step1ActionFollowedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1AlertCan> step1AlertCanList;
    @JoinColumn(name = "id_problem", referencedColumnName = "id")
    @ManyToOne
    private Problem idProblem;
    @JoinColumn(name = "user_validation", referencedColumnName = "id")
    @ManyToOne
    private User userValidation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1AlertShould> step1AlertShouldList;
    @OneToMany(mappedBy = "idStep1")
    private List<Problem> problemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1Why> step1WhyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStep1")
    private List<Step1View> step1ViewList;

    public Step1() {
    }

    public Step1(Integer id) {
        this.id = id;
    }

    public Step1(Integer id, boolean startValidation, boolean recognizedProblem, Date dateCreation) {
        this.id = id;
        this.startValidation = startValidation;
        this.recognizedProblem = recognizedProblem;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public Integer getHowMutch() {
        return howMutch;
    }

    public void setHowMutch(Integer howMutch) {
        this.howMutch = howMutch;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getBadPiece() {
        return badPiece;
    }

    public void setBadPiece(String badPiece) {
        this.badPiece = badPiece;
    }

    public String getGoodPiece() {
        return goodPiece;
    }

    public void setGoodPiece(String goodPiece) {
        this.goodPiece = goodPiece;
    }

    public Boolean getRespectStandard() {
        return respectStandard;
    }

    public void setRespectStandard(Boolean respectStandard) {
        this.respectStandard = respectStandard;
    }

    public Boolean getSort() {
        return sort;
    }

    public void setSort(Boolean sort) {
        this.sort = sort;
    }

    public String getSortCriterion() {
        return sortCriterion;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    public String getImmediateActions() {
        return immediateActions;
    }

    public void setImmediateActions(String immediateActions) {
        this.immediateActions = immediateActions;
    }

    public boolean getStartValidation() {
        return startValidation;
    }

    public void setStartValidation(boolean startValidation) {
        this.startValidation = startValidation;
    }

    public boolean getRecognizedProblem() {
        return recognizedProblem;
    }

    public void setRecognizedProblem(boolean recognizedProblem) {
        this.recognizedProblem = recognizedProblem;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    @XmlTransient
    public List<Step1Comment> getStep1CommentList() {
        return step1CommentList;
    }

    public void setStep1CommentList(List<Step1Comment> step1CommentList) {
        this.step1CommentList = step1CommentList;
    }

    @XmlTransient
    public List<Step1Action> getStep1ActionList() {
        return step1ActionList;
    }

    public void setStep1ActionList(List<Step1Action> step1ActionList) {
        this.step1ActionList = step1ActionList;
    }

    @XmlTransient
    public List<Step1Securisation> getStep1SecurisationList() {
        return step1SecurisationList;
    }

    public void setStep1SecurisationList(List<Step1Securisation> step1SecurisationList) {
        this.step1SecurisationList = step1SecurisationList;
    }

    @XmlTransient
    public List<Step1ActionFollowed> getStep1ActionFollowedList() {
        return step1ActionFollowedList;
    }

    public void setStep1ActionFollowedList(List<Step1ActionFollowed> step1ActionFollowedList) {
        this.step1ActionFollowedList = step1ActionFollowedList;
    }

    @XmlTransient
    public List<Step1AlertCan> getStep1AlertCanList() {
        return step1AlertCanList;
    }

    public void setStep1AlertCanList(List<Step1AlertCan> step1AlertCanList) {
        this.step1AlertCanList = step1AlertCanList;
    }

    public Problem getIdProblem() {
        return idProblem;
    }

    public void setIdProblem(Problem idProblem) {
        this.idProblem = idProblem;
    }

    public User getUserValidation() {
        return userValidation;
    }

    public void setUserValidation(User userValidation) {
        this.userValidation = userValidation;
    }

    @XmlTransient
    public List<Step1AlertShould> getStep1AlertShouldList() {
        return step1AlertShouldList;
    }

    public void setStep1AlertShouldList(List<Step1AlertShould> step1AlertShouldList) {
        this.step1AlertShouldList = step1AlertShouldList;
    }

    @XmlTransient
    public List<Problem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }

    @XmlTransient
    public List<Step1Why> getStep1WhyList() {
        return step1WhyList;
    }

    public void setStep1WhyList(List<Step1Why> step1WhyList) {
        this.step1WhyList = step1WhyList;
    }

    @XmlTransient
    public List<Step1View> getStep1ViewList() {
        return step1ViewList;
    }

    public void setStep1ViewList(List<Step1View> step1ViewList) {
        this.step1ViewList = step1ViewList;
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
        if (!(object instanceof Step1)) {
            return false;
        }
        Step1 other = (Step1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Step1[ id=" + id + " ]";
    }
    
}
