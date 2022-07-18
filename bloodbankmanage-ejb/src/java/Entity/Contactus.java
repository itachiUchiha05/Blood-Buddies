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
@Table(name = "contactus", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Contactus.findAll", query = "SELECT c FROM Contactus c WHERE c.isActive = 1"),
    @NamedQuery(name = "Contactus.findByCnoIDPK", query = "SELECT c FROM Contactus c WHERE c.cnoIDPK = :cnoIDPK"),
    @NamedQuery(name = "Contactus.findByCname", query = "SELECT c FROM Contactus c WHERE c.cname = :cname"),
    @NamedQuery(name = "Contactus.findByEmail", query = "SELECT c FROM Contactus c WHERE c.email = :email"),
    @NamedQuery(name = "Contactus.findBySubject", query = "SELECT c FROM Contactus c WHERE c.subject = :subject"),
    @NamedQuery(name = "Contactus.findByMessage", query = "SELECT c FROM Contactus c WHERE c.message = :message"),
    @NamedQuery(name = "Contactus.findByIsActive", query = "SELECT c FROM Contactus c WHERE c.isActive = :isActive")})
public class Contactus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cnoIDPK", nullable = false)
    private Integer cnoIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cname", nullable = false, length = 255)
    private String cname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subject", nullable = false, length = 255)
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "message", nullable = false, length = 255)
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    public Contactus() {
    }

    public Contactus(Integer cnoIDPK) {
        this.cnoIDPK = cnoIDPK;
    }

    public Contactus(Integer cnoIDPK, String cname, String email, String subject, String message, boolean isActive) {
        this.cnoIDPK = cnoIDPK;
        this.cname = cname;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.isActive = isActive;
    }

    public Integer getCnoIDPK() {
        return cnoIDPK;
    }

    public void setCnoIDPK(Integer cnoIDPK) {
        this.cnoIDPK = cnoIDPK;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnoIDPK != null ? cnoIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactus)) {
            return false;
        }
        Contactus other = (Contactus) object;
        if ((this.cnoIDPK == null && other.cnoIDPK != null) || (this.cnoIDPK != null && !this.cnoIDPK.equals(other.cnoIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Contactus[ cnoIDPK=" + cnoIDPK + " ]";
    }
    
}
