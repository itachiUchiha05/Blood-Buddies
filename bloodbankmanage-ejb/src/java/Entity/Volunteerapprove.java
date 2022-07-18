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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "volunteerapprove", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Volunteerapprove.findAll", query = "SELECT v FROM Volunteerapprove v WHERE v.isActive = 1"),
    @NamedQuery(name = "Volunteerapprove.findByVolapIDPK", query = "SELECT v FROM Volunteerapprove v WHERE v.volapIDPK = :volapIDPK"),
    @NamedQuery(name = "Volunteerapprove.findByIsActive", query = "SELECT v FROM Volunteerapprove v WHERE v.isActive = :isActive")})
public class Volunteerapprove implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "volapIDPK", nullable = false)
    private Integer volapIDPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "bloodCampIDFK", referencedColumnName = "bloodCampIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Bloodcamp bloodCampIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "volapIDFK")
    private Collection<Volunteerrating> volunteerratingCollection;

    public Volunteerapprove() {
    }

    public Volunteerapprove(Integer volapIDPK) {
        this.volapIDPK = volapIDPK;
    }

    public Volunteerapprove(Integer volapIDPK, boolean isActive) {
        this.volapIDPK = volapIDPK;
        this.isActive = isActive;
    }

    public Integer getVolapIDPK() {
        return volapIDPK;
    }

    public void setVolapIDPK(Integer volapIDPK) {
        this.volapIDPK = volapIDPK;
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

    public Bloodcamp getBloodCampIDFK() {
        return bloodCampIDFK;
    }

    public void setBloodCampIDFK(Bloodcamp bloodCampIDFK) {
        this.bloodCampIDFK = bloodCampIDFK;
    }

    @XmlTransient
    public Collection<Volunteerrating> getVolunteerratingCollection() {
        return volunteerratingCollection;
    }

    public void setVolunteerratingCollection(Collection<Volunteerrating> volunteerratingCollection) {
        this.volunteerratingCollection = volunteerratingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (volapIDPK != null ? volapIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volunteerapprove)) {
            return false;
        }
        Volunteerapprove other = (Volunteerapprove) object;
        if ((this.volapIDPK == null && other.volapIDPK != null) || (this.volapIDPK != null && !this.volapIDPK.equals(other.volapIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Volunteerapprove[ volapIDPK=" + volapIDPK + " ]";
    }
    
}
