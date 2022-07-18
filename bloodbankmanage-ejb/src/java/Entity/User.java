/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Admin
 */
@Entity
@Table(name = "user", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u WHERE u.isActive = 1"),
    @NamedQuery(name = "User.findByUserIDPK", query = "SELECT u FROM User u WHERE u.userIDPK = :userIDPK"),
    @NamedQuery(name = "User.findByUser", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail and u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserAge", query = "SELECT u FROM User u WHERE u.userAge = :userAge"),
    @NamedQuery(name = "User.findByUserGender", query = "SELECT u FROM User u WHERE u.userGender = :userGender"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserBloodGrp", query = "SELECT u FROM User u WHERE u.userBloodGrp = :userBloodGrp"),
    @NamedQuery(name = "User.findByUserContact", query = "SELECT u FROM User u WHERE u.userContact = :userContact"),
    @NamedQuery(name = "User.findByUserLocation", query = "SELECT u FROM User u WHERE u.userLocation = :userLocation"),
    @NamedQuery(name = "User.findByUserpic", query = "SELECT u FROM User u WHERE u.userpic = :userpic"),
    @NamedQuery(name = "User.findByDate", query = "SELECT u FROM User u WHERE u.date = :date"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userIDPK", nullable = false)
    private Integer userIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userName", nullable = false, length = 255)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userAge", nullable = false, length = 255)
    private String userAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userGender", nullable = false, length = 255)
    private String userGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userEmail", nullable = false, length = 255)
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userPassword", nullable = false, length = 255)
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userBloodGrp", nullable = false, length = 255)
    private String userBloodGrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userContact", nullable = false, length = 255)
    private String userContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userLocation", nullable = false, length = 255)
    private String userLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "userpic", nullable = false, length = 5000)
    private String userpic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Date", nullable = false, length = 255)
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "userType", nullable = false, length = 5000)
    private String userType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Volunteerapprove> volunteerapproveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Volunteerrating> volunteerratingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Doner> donerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Volunteerreq> volunteerreqCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Bloodcamprequest> bloodcamprequestCollection;
    @JoinColumn(name = "cityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private City cityIDFK;

    public User() {
    }

    public User(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public User(Integer userIDPK, String userName, String userAge, String userGender, String userEmail, String userPassword, String userBloodGrp, String userContact, String userLocation, String userpic, String date, String userType, boolean isActive) {
        this.userIDPK = userIDPK;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userBloodGrp = userBloodGrp;
        this.userContact = userContact;
        this.userLocation = userLocation;
        this.userpic = userpic;
        this.date = date;
        this.userType = userType;
        this.isActive = isActive;
    }

    public Integer getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserBloodGrp() {
        return userBloodGrp;
    }

    public void setUserBloodGrp(String userBloodGrp) {
        this.userBloodGrp = userBloodGrp;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Volunteerapprove> getVolunteerapproveCollection() {
        return volunteerapproveCollection;
    }

    public void setVolunteerapproveCollection(Collection<Volunteerapprove> volunteerapproveCollection) {
        this.volunteerapproveCollection = volunteerapproveCollection;
    }

    @XmlTransient
    public Collection<Volunteerrating> getVolunteerratingCollection() {
        return volunteerratingCollection;
    }

    public void setVolunteerratingCollection(Collection<Volunteerrating> volunteerratingCollection) {
        this.volunteerratingCollection = volunteerratingCollection;
    }

    @XmlTransient
    public Collection<Doner> getDonerCollection() {
        return donerCollection;
    }

    public void setDonerCollection(Collection<Doner> donerCollection) {
        this.donerCollection = donerCollection;
    }

    @XmlTransient
    public Collection<Volunteerreq> getVolunteerreqCollection() {
        return volunteerreqCollection;
    }

    public void setVolunteerreqCollection(Collection<Volunteerreq> volunteerreqCollection) {
        this.volunteerreqCollection = volunteerreqCollection;
    }

    @XmlTransient
    public Collection<Bloodcamprequest> getBloodcamprequestCollection() {
        return bloodcamprequestCollection;
    }

    public void setBloodcamprequestCollection(Collection<Bloodcamprequest> bloodcamprequestCollection) {
        this.bloodcamprequestCollection = bloodcamprequestCollection;
    }

    public City getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(City cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIDPK != null ? userIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userIDPK == null && other.userIDPK != null) || (this.userIDPK != null && !this.userIDPK.equals(other.userIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.User[ userIDPK=" + userIDPK + " ]";
    }
    
}
