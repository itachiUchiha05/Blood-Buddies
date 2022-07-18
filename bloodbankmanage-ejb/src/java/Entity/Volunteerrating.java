/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "volunteerrating", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Volunteerrating.findAll", query = "SELECT v FROM Volunteerrating v WHERE v.isActive = 1"),
    @NamedQuery(name = "Volunteerrating.findByVolRatIDPK", query = "SELECT v FROM Volunteerrating v WHERE v.volRatIDPK = :volRatIDPK"),
    @NamedQuery(name = "Volunteerrating.findByRating", query = "SELECT v FROM Volunteerrating v WHERE v.rating = :rating"),
    @NamedQuery(name = "Volunteerrating.findByMessage", query = "SELECT v FROM Volunteerrating v WHERE v.message = :message"),
    @NamedQuery(name = "Volunteerrating.findByIsActive", query = "SELECT v FROM Volunteerrating v WHERE v.isActive = :isActive")})
public class Volunteerrating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "volRatIDPK", nullable = false)
    private Integer volRatIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rating", nullable = false, length = 255)
    private String rating;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "message", nullable = false, length = 255)
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "volapIDFK", referencedColumnName = "volapIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Volunteerapprove volapIDFK;

    public Volunteerrating() {
    }

    public Volunteerrating(Integer volRatIDPK) {
        this.volRatIDPK = volRatIDPK;
    }

    public Volunteerrating(Integer volRatIDPK, String rating, String message, boolean isActive) {
        this.volRatIDPK = volRatIDPK;
        this.rating = rating;
        this.message = message;
        this.isActive = isActive;
    }

    public Integer getVolRatIDPK() {
        return volRatIDPK;
    }

    public void setVolRatIDPK(Integer volRatIDPK) {
        this.volRatIDPK = volRatIDPK;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    public Volunteerapprove getVolapIDFK() {
        return volapIDFK;
    }

    public void setVolapIDFK(Volunteerapprove volapIDFK) {
        this.volapIDFK = volapIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (volRatIDPK != null ? volRatIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volunteerrating)) {
            return false;
        }
        Volunteerrating other = (Volunteerrating) object;
        if ((this.volRatIDPK == null && other.volRatIDPK != null) || (this.volRatIDPK != null && !this.volRatIDPK.equals(other.volRatIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Volunteerrating[ volRatIDPK=" + volRatIDPK + " ]";
    }
    
}
