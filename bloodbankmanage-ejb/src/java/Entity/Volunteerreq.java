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
@Table(name = "volunteerreq", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Volunteerreq.findAll", query = "SELECT v FROM Volunteerreq v WHERE v.isActive = 1"),
    @NamedQuery(name = "Volunteerreq.findByuserIDFK", query = "SELECT v FROM Volunteerreq v WHERE v.userIDFK.userIDPK = :userIDFK"),
    @NamedQuery(name = "Volunteerreq.findByVolIDPK", query = "SELECT v FROM Volunteerreq v WHERE v.volIDPK = :volIDPK"),
    @NamedQuery(name = "Volunteerreq.findByEmergencyCon", query = "SELECT v FROM Volunteerreq v WHERE v.emergencyCon = :emergencyCon"),
    @NamedQuery(name = "Volunteerreq.findByPrefferedTime", query = "SELECT v FROM Volunteerreq v WHERE v.prefferedTime = :prefferedTime"),
    @NamedQuery(name = "Volunteerreq.findByExpierence", query = "SELECT v FROM Volunteerreq v WHERE v.expierence = :expierence"),
    @NamedQuery(name = "Volunteerreq.findByStatus", query = "SELECT v FROM Volunteerreq v WHERE v.status = :status"),
    @NamedQuery(name = "Volunteerreq.findByIsActive", query = "SELECT v FROM Volunteerreq v WHERE v.isActive = :isActive")})
public class Volunteerreq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "volIDPK", nullable = false)
    private Integer volIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emergencyCon", nullable = false, length = 255)
    private String emergencyCon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prefferedTime", nullable = false, length = 255)
    private String prefferedTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "expierence", nullable = false, length = 255)
    private String expierence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "bloodCampIDFK", referencedColumnName = "bloodCampIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Bloodcamp bloodCampIDFK;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;

    public Volunteerreq() {
    }

    public Volunteerreq(Integer volIDPK) {
        this.volIDPK = volIDPK;
    }

    public Volunteerreq(Integer volIDPK, String emergencyCon, String prefferedTime, String expierence, String status, boolean isActive) {
        this.volIDPK = volIDPK;
        this.emergencyCon = emergencyCon;
        this.prefferedTime = prefferedTime;
        this.expierence = expierence;
        this.status = status;
        this.isActive = isActive;
    }

    public Integer getVolIDPK() {
        return volIDPK;
    }

    public void setVolIDPK(Integer volIDPK) {
        this.volIDPK = volIDPK;
    }

    public String getEmergencyCon() {
        return emergencyCon;
    }

    public void setEmergencyCon(String emergencyCon) {
        this.emergencyCon = emergencyCon;
    }

    public String getPrefferedTime() {
        return prefferedTime;
    }

    public void setPrefferedTime(String prefferedTime) {
        this.prefferedTime = prefferedTime;
    }

    public String getExpierence() {
        return expierence;
    }

    public void setExpierence(String expierence) {
        this.expierence = expierence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Bloodcamp getBloodCampIDFK() {
        return bloodCampIDFK;
    }

    public void setBloodCampIDFK(Bloodcamp bloodCampIDFK) {
        this.bloodCampIDFK = bloodCampIDFK;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (volIDPK != null ? volIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volunteerreq)) {
            return false;
        }
        Volunteerreq other = (Volunteerreq) object;
        if ((this.volIDPK == null && other.volIDPK != null) || (this.volIDPK != null && !this.volIDPK.equals(other.volIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Volunteerreq[ volIDPK=" + volIDPK + " ]";
    }
    
}
