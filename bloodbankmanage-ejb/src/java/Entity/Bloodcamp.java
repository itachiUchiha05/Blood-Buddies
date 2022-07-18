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
@Table(name = "bloodcamp", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Bloodcamp.findAll", query = "SELECT b FROM Bloodcamp b WHERE b.isActive = 1"),
    @NamedQuery(name = "Bloodcamp.findByBloodCampIDPK", query = "SELECT b FROM Bloodcamp b WHERE b.bloodCampIDPK = :bloodCampIDPK"),
    @NamedQuery(name = "Bloodcamp.findByOrgname", query = "SELECT b FROM Bloodcamp b WHERE b.orgname = :orgname"),
    @NamedQuery(name = "Bloodcamp.findByOrgcontact", query = "SELECT b FROM Bloodcamp b WHERE b.orgcontact = :orgcontact"),
    @NamedQuery(name = "Bloodcamp.findByLocation", query = "SELECT b FROM Bloodcamp b WHERE b.location = :location"),
    @NamedQuery(name = "Bloodcamp.findByTiming", query = "SELECT b FROM Bloodcamp b WHERE b.timing = :timing"),
    @NamedQuery(name = "Bloodcamp.findByCampdate", query = "SELECT b FROM Bloodcamp b WHERE b.campdate = :campdate"),
     @NamedQuery(name = "Bloodcamp.findByCityIDFK", query = "SELECT b FROM Bloodcamp b WHERE b.cityIDFK.cityIDPK = :cityIDFK"),
    @NamedQuery(name = "Bloodcamp.findByIsActive", query = "SELECT b FROM Bloodcamp b WHERE b.isActive = :isActive")})
public class Bloodcamp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bloodCampIDPK", nullable = false)
    private Integer bloodCampIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "orgname", nullable = false, length = 255)
    private String orgname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "orgcontact", nullable = false, length = 255)
    private String orgcontact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location", nullable = false, length = 255)
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "timing", nullable = false, length = 5000)
    private String timing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "campdate", nullable = false, length = 255)
    private String campdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloodCampIDFK")
    private Collection<Volunteerapprove> volunteerapproveCollection;
    @JoinColumn(name = "CityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private City cityIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloodCampIDFK")
    private Collection<Doner> donerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloodCampIDFK")
    private Collection<Volunteerreq> volunteerreqCollection;

    public Bloodcamp() {
    }

    public Bloodcamp(Integer bloodCampIDPK) {
        this.bloodCampIDPK = bloodCampIDPK;
    }

    public Bloodcamp(Integer bloodCampIDPK, String orgname, String orgcontact, String location, String timing, String campdate, boolean isActive) {
        this.bloodCampIDPK = bloodCampIDPK;
        this.orgname = orgname;
        this.orgcontact = orgcontact;
        this.location = location;
        this.timing = timing;
        this.campdate = campdate;
        this.isActive = isActive;
    }

    public Integer getBloodCampIDPK() {
        return bloodCampIDPK;
    }

    public void setBloodCampIDPK(Integer bloodCampIDPK) {
        this.bloodCampIDPK = bloodCampIDPK;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrgcontact() {
        return orgcontact;
    }

    public void setOrgcontact(String orgcontact) {
        this.orgcontact = orgcontact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getCampdate() {
        return campdate;
    }

    public void setCampdate(String campdate) {
        this.campdate = campdate;
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

    public City getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(City cityIDFK) {
        this.cityIDFK = cityIDFK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloodCampIDPK != null ? bloodCampIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodcamp)) {
            return false;
        }
        Bloodcamp other = (Bloodcamp) object;
        if ((this.bloodCampIDPK == null && other.bloodCampIDPK != null) || (this.bloodCampIDPK != null && !this.bloodCampIDPK.equals(other.bloodCampIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bloodcamp[ bloodCampIDPK=" + bloodCampIDPK + " ]";
    }
    
}
