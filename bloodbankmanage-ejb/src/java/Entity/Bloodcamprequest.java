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
@Table(name = "bloodcamprequest", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Bloodcamprequest.findAll", query = "SELECT b FROM Bloodcamprequest b WHERE b.isActive = 1"),
    @NamedQuery(name = "Bloodcamprequest.findByCampReqIDPK", query = "SELECT b FROM Bloodcamprequest b WHERE b.campReqIDPK = :campReqIDPK"),
    @NamedQuery(name = "Bloodcamprequest.findByLocation", query = "SELECT b FROM Bloodcamprequest b WHERE b.location = :location"),
    @NamedQuery(name = "Bloodcamprequest.findByApproxDoner", query = "SELECT b FROM Bloodcamprequest b WHERE b.approxDoner = :approxDoner"),
    @NamedQuery(name = "Bloodcamprequest.findByReqCampDate", query = "SELECT b FROM Bloodcamprequest b WHERE b.reqCampDate = :reqCampDate"),
    @NamedQuery(name = "Bloodcamprequest.findByIsRead", query = "SELECT b FROM Bloodcamprequest b WHERE b.isRead = :isRead"),
    @NamedQuery(name = "Bloodcamprequest.findByNotifyAll", query = "SELECT b FROM Bloodcamprequest b WHERE b.isRead=1"),
     @NamedQuery(name = "Bloodcamprequest.findByNotify", query = "UPDATE Bloodcamprequest b set b.isRead=0"),
    @NamedQuery(name = "Bloodcamprequest.findByIsActive", query = "SELECT b FROM Bloodcamprequest b WHERE b.isActive = :isActive")})
public class Bloodcamprequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CampReqIDPK", nullable = false)
    private Integer campReqIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location", nullable = false, length = 255)
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "approxDoner", nullable = false, length = 255)
    private String approxDoner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reqCampDate", nullable = false, length = 255)
    private String reqCampDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isRead", nullable = false)
    private boolean isRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "cityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private City cityIDFK;

    public Bloodcamprequest() {
    }

    public Bloodcamprequest(Integer campReqIDPK) {
        this.campReqIDPK = campReqIDPK;
    }

    public Bloodcamprequest(Integer campReqIDPK, String location, String approxDoner, String reqCampDate, boolean isRead, boolean isActive) {
        this.campReqIDPK = campReqIDPK;
        this.location = location;
        this.approxDoner = approxDoner;
        this.reqCampDate = reqCampDate;
        this.isRead = isRead;
        this.isActive = isActive;
    }

    public Integer getCampReqIDPK() {
        return campReqIDPK;
    }

    public void setCampReqIDPK(Integer campReqIDPK) {
        this.campReqIDPK = campReqIDPK;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApproxDoner() {
        return approxDoner;
    }

    public void setApproxDoner(String approxDoner) {
        this.approxDoner = approxDoner;
    }

    public String getReqCampDate() {
        return reqCampDate;
    }

    public void setReqCampDate(String reqCampDate) {
        this.reqCampDate = reqCampDate;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
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

    public City getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(City cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campReqIDPK != null ? campReqIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodcamprequest)) {
            return false;
        }
        Bloodcamprequest other = (Bloodcamprequest) object;
        if ((this.campReqIDPK == null && other.campReqIDPK != null) || (this.campReqIDPK != null && !this.campReqIDPK.equals(other.campReqIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bloodcamprequest[ campReqIDPK=" + campReqIDPK + " ]";
    }
    
}
