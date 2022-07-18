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
@Table(name = "doner", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Doner.findAll", query = "SELECT d FROM Doner d WHERE d.isActive = 1"),
    @NamedQuery(name = "Doner.findByDonerIDPK", query = "SELECT d FROM Doner d WHERE d.donerIDPK = :donerIDPK"),
    @NamedQuery(name = "Doner.findByDimageid", query = "SELECT d FROM Doner d WHERE d.dimageid = :dimageid"),
    @NamedQuery(name = "Doner.findByBloodQuantity", query = "SELECT d FROM Doner d WHERE d.bloodQuantity = :bloodQuantity"),
    @NamedQuery(name = "Doner.findByDateOfDon", query = "SELECT d FROM Doner d WHERE d.dateOfDon = :dateOfDon"),
    @NamedQuery(name = "Doner.findByLastDateOfDon", query = "SELECT d FROM Doner d WHERE d.lastDateOfDon = :lastDateOfDon"),
    @NamedQuery(name = "Doner.findBybloodcamp", query = "SELECT d FROM Doner d WHERE d.bloodCampIDFK.bloodCampIDPK = :bloodCampIDFK"),
    @NamedQuery(name = "Doner.findByIsActive", query = "SELECT d FROM Doner d WHERE d.isActive = :isActive")})
public class Doner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "donerIDPK", nullable = false)
    private Integer donerIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "dimageid", nullable = false, length = 5000)
    private String dimageid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bloodQuantity", nullable = false, length = 255)
    private String bloodQuantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dateOfDon", nullable = false, length = 255)
    private String dateOfDon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lastDateOfDon", nullable = false, length = 255)
    private String lastDateOfDon;
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

    public Doner() {
    }

    public Doner(Integer donerIDPK) {
        this.donerIDPK = donerIDPK;
    }

    public Doner(Integer donerIDPK, String dimageid, String bloodQuantity, String dateOfDon, String lastDateOfDon, boolean isActive) {
        this.donerIDPK = donerIDPK;
        this.dimageid = dimageid;
        this.bloodQuantity = bloodQuantity;
        this.dateOfDon = dateOfDon;
        this.lastDateOfDon = lastDateOfDon;
        this.isActive = isActive;
    }

    public Integer getDonerIDPK() {
        return donerIDPK;
    }

    public void setDonerIDPK(Integer donerIDPK) {
        this.donerIDPK = donerIDPK;
    }

    public String getDimageid() {
        return dimageid;
    }

    public void setDimageid(String dimageid) {
        this.dimageid = dimageid;
    }

    public String getBloodQuantity() {
        return bloodQuantity;
    }

    public void setBloodQuantity(String bloodQuantity) {
        this.bloodQuantity = bloodQuantity;
    }

    public String getDateOfDon() {
        return dateOfDon;
    }

    public void setDateOfDon(String dateOfDon) {
        this.dateOfDon = dateOfDon;
    }

    public String getLastDateOfDon() {
        return lastDateOfDon;
    }

    public void setLastDateOfDon(String lastDateOfDon) {
        this.lastDateOfDon = lastDateOfDon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donerIDPK != null ? donerIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doner)) {
            return false;
        }
        Doner other = (Doner) object;
        if ((this.donerIDPK == null && other.donerIDPK != null) || (this.donerIDPK != null && !this.donerIDPK.equals(other.donerIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Doner[ donerIDPK=" + donerIDPK + " ]";
    }
    
}
