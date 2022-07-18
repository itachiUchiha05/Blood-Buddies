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
@Table(name = "bloodbank", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bloodbank.findAll", query = "SELECT b FROM Bloodbank b WHERE b.isActive = 1"),
    @NamedQuery(name = "Bloodbank.findByBloodBankIDPK", query = "SELECT b FROM Bloodbank b WHERE b.bloodBankIDPK = :bloodBankIDPK"),
    @NamedQuery(name = "Bloodbank.findByBloodBankName", query = "SELECT b FROM Bloodbank b WHERE b.bloodBankName = :bloodBankName"),
    @NamedQuery(name = "Bloodbank.findByBloodBankAddress", query = "SELECT b FROM Bloodbank b WHERE b.bloodBankAddress = :bloodBankAddress"),
    @NamedQuery(name = "Bloodbank.findByContactperson", query = "SELECT b FROM Bloodbank b WHERE b.contactperson = :contactperson"),
    @NamedQuery(name = "Bloodbank.findByContactnumber", query = "SELECT b FROM Bloodbank b WHERE b.contactnumber = :contactnumber"),
    @NamedQuery(name = "Bloodbank.findByBloodBankPortal", query = "SELECT b FROM Bloodbank b WHERE b.bloodBankPortal = :bloodBankPortal"),
    @NamedQuery(name = "Bloodbank.findByIsActive", query = "SELECT b FROM Bloodbank b WHERE b.isActive = :isActive")})
public class Bloodbank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bloodBankIDPK", nullable = false)
    private Integer bloodBankIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bloodBankName", nullable = false, length = 255)
    private String bloodBankName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bloodBankAddress", nullable = false, length = 255)
    private String bloodBankAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contactperson", nullable = false, length = 255)
    private String contactperson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contactnumber", nullable = false, length = 255)
    private String contactnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bloodBankPortal", nullable = false, length = 255)
    private String bloodBankPortal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "cityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private City cityIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloodBankIDFK")
    private Collection<Bloodrequest> bloodrequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloodBankIDFK")
    private Collection<Bloodstock> bloodstockCollection;

    public Bloodbank() {
    }

    public Bloodbank(Integer bloodBankIDPK) {
        this.bloodBankIDPK = bloodBankIDPK;
    }

    public Bloodbank(Integer bloodBankIDPK, String bloodBankName, String bloodBankAddress, String contactperson, String contactnumber, String bloodBankPortal, boolean isActive) {
        this.bloodBankIDPK = bloodBankIDPK;
        this.bloodBankName = bloodBankName;
        this.bloodBankAddress = bloodBankAddress;
        this.contactperson = contactperson;
        this.contactnumber = contactnumber;
        this.bloodBankPortal = bloodBankPortal;
        this.isActive = isActive;
    }

    public Integer getBloodBankIDPK() {
        return bloodBankIDPK;
    }

    public void setBloodBankIDPK(Integer bloodBankIDPK) {
        this.bloodBankIDPK = bloodBankIDPK;
    }

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    public String getBloodBankAddress() {
        return bloodBankAddress;
    }

    public void setBloodBankAddress(String bloodBankAddress) {
        this.bloodBankAddress = bloodBankAddress;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getBloodBankPortal() {
        return bloodBankPortal;
    }

    public void setBloodBankPortal(String bloodBankPortal) {
        this.bloodBankPortal = bloodBankPortal;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public City getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(City cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    @XmlTransient
    public Collection<Bloodrequest> getBloodrequestCollection() {
        return bloodrequestCollection;
    }

    public void setBloodrequestCollection(Collection<Bloodrequest> bloodrequestCollection) {
        this.bloodrequestCollection = bloodrequestCollection;
    }

    @XmlTransient
    public Collection<Bloodstock> getBloodstockCollection() {
        return bloodstockCollection;
    }

    public void setBloodstockCollection(Collection<Bloodstock> bloodstockCollection) {
        this.bloodstockCollection = bloodstockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloodBankIDPK != null ? bloodBankIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodbank)) {
            return false;
        }
        Bloodbank other = (Bloodbank) object;
        if ((this.bloodBankIDPK == null && other.bloodBankIDPK != null) || (this.bloodBankIDPK != null && !this.bloodBankIDPK.equals(other.bloodBankIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bloodbank[ bloodBankIDPK=" + bloodBankIDPK + " ]";
    }
    
}
