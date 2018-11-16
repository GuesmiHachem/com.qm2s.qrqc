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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findByBirthday", query = "SELECT u FROM User u WHERE u.birthday = :birthday")
    , @NamedQuery(name = "User.findByCin", query = "SELECT u FROM User u WHERE u.cin = :cin")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByMatricule", query = "SELECT u FROM User u WHERE u.matricule = :matricule")
    , @NamedQuery(name = "User.findByTel", query = "SELECT u FROM User u WHERE u.tel = :tel")
    , @NamedQuery(name = "User.findByPicture", query = "SELECT u FROM User u WHERE u.picture = :picture")
    , @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "birthday")
    private String birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cin")
    private String cin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tel")
    private String tel;
    @Size(max = 50)
    @Column(name = "picture")
    private String picture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Step1Comment> step1CommentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "affectedTo")
    private List<Step1Action> step1ActionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "affectedTo")
    private List<Step1Securisation> step1SecurisationList;
    @OneToMany(mappedBy = "userValidation")
    private List<Step1> step1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Notification> notificationList;
    @OneToMany(mappedBy = "idUser")
    private List<Processus> processusList;
    @OneToMany(mappedBy = "idUser")
    private List<Problem> problemList;
    @JoinColumn(name = "id_level0", referencedColumnName = "id")
    @ManyToOne
    private Level0 idLevel0;
    @JoinColumn(name = "id_level1", referencedColumnName = "id")
    @ManyToOne
    private Level1 idLevel1;
    @JoinColumn(name = "id_level2", referencedColumnName = "id")
    @ManyToOne
    private Level2 idLevel2;
    @JoinColumn(name = "id_level3", referencedColumnName = "id")
    @ManyToOne
    private Level3 idLevel3;
    @JoinColumn(name = "id_type_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeUser idTypeUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Step1View> step1ViewList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String cin, String email, String matricule, String tel, String login, String password, boolean active) {
        this.id = id;
        this.cin = cin;
        this.email = email;
        this.matricule = matricule;
        this.tel = tel;
        this.login = login;
        this.password = password;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @XmlTransient
    public List<Processus> getProcessusList() {
        return processusList;
    }

    public void setProcessusList(List<Processus> processusList) {
        this.processusList = processusList;
    }

    @XmlTransient
    public List<Problem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }

    public Level0 getIdLevel0() {
        return idLevel0;
    }

    public void setIdLevel0(Level0 idLevel0) {
        this.idLevel0 = idLevel0;
    }

    public Level1 getIdLevel1() {
        return idLevel1;
    }

    public void setIdLevel1(Level1 idLevel1) {
        this.idLevel1 = idLevel1;
    }

    public Level2 getIdLevel2() {
        return idLevel2;
    }

    public void setIdLevel2(Level2 idLevel2) {
        this.idLevel2 = idLevel2;
    }

    public Level3 getIdLevel3() {
        return idLevel3;
    }

    public void setIdLevel3(Level3 idLevel3) {
        this.idLevel3 = idLevel3;
    }

    public TypeUser getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(TypeUser idTypeUser) {
        this.idTypeUser = idTypeUser;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ id=" + id + " ]";
    }
    
}
