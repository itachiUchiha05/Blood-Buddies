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
@Table(name = "bloodrequest", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bloodrequest.findAll", query = "SELECT b FROM Bloodrequest b WHERE b.isActive = 1"),
    @NamedQuery(name = "Bloodrequest.findByReqIDPK", query = "SELECT b FROM Bloodrequest b WHERE b.reqIDPK = :reqIDPK"),
    @NamedQuery(name = "Bloodrequest.findBySname", query = "SELECT b FROM Bloodrequest b WHERE b.sname = :sname"),
    @NamedQuery(name = "Bloodrequest.findByDob", query = "SELECT b FROM Bloodrequest b WHERE b.dob = :dob"),
    @NamedQuery(name = "Bloodrequest.findByReqBloodGrp", query = "SELECT b FROM Bloodrequest b WHERE b.reqBloodGrp = :reqBloodGrp"),
    @NamedQuery(name = "Bloodrequest.findByReqUnit", query = "SELECT b FROM Bloodrequest b WHERE b.reqUnit = :reqUnit"),
    @NamedQuery(name = "Bloodrequest.findByReqDate", query = "SELECT b FROM Bloodrequest b WHERE b.reqDate = :reqDate"),
    @NamedQuery(name = "Bloodrequest.findByContact", query = "SELECT b FROM Bloodrequest b WHERE b.contact = :contact"),
    @NamedQuery(name = "Bloodrequest.findBySimageid", query = "SELECT b FROM Bloodrequest b WHERE b.simageid = :simageid"),
    @NamedQuery(name = "Bloodrequest.findByStatus", query = "SELECT b FROM Bloodrequest b WHERE b.status = :status"),
    @NamedQuery(name = "Bloodrequest.findByIsActive", query = "SELECT b FROM Bloodrequest b WHERE b.isActive = :isActive")})
public class Bloodrequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reqIDPK", nullable = false)
    private Integer reqIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sname", nullable = false, length = 255)
    private String sname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "dob", nullable = false, length = 5000)
    private String dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reqBloodGrp", nullable = false, length = 255)
    private String reqBloodGrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reqUnit", nullable = false, length = 255)
    private String reqUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reqDate", nullable = false, length = 255)
    private String reqDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "contact", nullable = false, length = 5000)
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "simageid", nullable = false, length = 5000)
    private String simageid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "bloodBankIDFK", referencedColumnName = "bloodBankIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Bloodbank bloodBankIDFK;

    public Bloodrequest() {
    }

    public Bloodrequest(Integer reqIDPK) {
        this.reqIDPK = reqIDPK;
    }

    public Bloodrequest(Integer reqIDPK, String sname, String dob, String reqBloodGrp, String reqUnit, String reqDate, String contact, String simageid, String status, boolean isActive) {
        this.reqIDPK = reqIDPK;
        this.sname = sname;
        this.dob = dob;
        this.reqBloodGrp = reqBloodGrp;
        this.reqUnit = reqUnit;
        this.reqDate = reqDate;
        this.contact = contact;
        this.simageid = simageid;
        this.status = status;
        this.isActive = isActive;
    }

    public Integer getReqIDPK() {
        return reqIDPK;
    }

    public void setReqIDPK(Integer reqIDPK) {
        this.reqIDPK = reqIDPK;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getReqBloodGrp() {
        return reqBloodGrp;
    }

    public void setReqBloodGrp(String reqBloodGrp) {
        this.reqBloodGrp = reqBloodGrp;
    }

    public String getReqUnit() {
        return reqUnit;
    }

    public void setReqUnit(String reqUnit) {
        this.reqUnit = reqUnit;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSimageid() {
        return simageid;
    }

    public void setSimageid(String simageid) {
        this.simageid = simageid;
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

    public Bloodbank getBloodBankIDFK() {
        return bloodBankIDFK;
    }

    public void setBloodBankIDFK(Bloodbank bloodBankIDFK) {
        this.bloodBankIDFK = bloodBankIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqIDPK != null ? reqIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodrequest)) {
            return false;
        }
        Bloodrequest other = (Bloodrequest) object;
        if ((this.reqIDPK == null && other.reqIDPK != null) || (this.reqIDPK != null && !this.reqIDPK.equals(other.reqIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bloodrequest[ reqIDPK=" + reqIDPK + " ]";
    }
    
}
