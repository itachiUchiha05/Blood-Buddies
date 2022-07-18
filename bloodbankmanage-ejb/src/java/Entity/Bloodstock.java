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
@Table(name = "bloodstock", catalog = "bloodbankdb", schema = "")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Bloodstock.findAll", query = "SELECT b FROM Bloodstock b WHERE b.isActive = 1"),
    @NamedQuery(name = "Bloodstock.findByStockIDPK", query = "SELECT b FROM Bloodstock b WHERE b.stockIDPK = :stockIDPK"),
    @NamedQuery(name = "Bloodstock.findByQuantity", query = "SELECT b FROM Bloodstock b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Bloodstock.findByBestBefore", query = "SELECT b FROM Bloodstock b WHERE b.bestBefore = :bestBefore"),
    @NamedQuery(name = "Bloodstock.findByIsActive", query = "SELECT b FROM Bloodstock b WHERE b.isActive = :isActive")})
public class Bloodstock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stockIDPK", nullable = false)
    private Integer stockIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "quantity", nullable = false, length = 255)
    private String quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bestBefore", nullable = false, length = 255)
    private String bestBefore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "bloodBankIDFK", referencedColumnName = "bloodBankIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Bloodbank bloodBankIDFK;

    public Bloodstock() {
    }

    public Bloodstock(Integer stockIDPK) {
        this.stockIDPK = stockIDPK;
    }

    public Bloodstock(Integer stockIDPK, String quantity, String bestBefore, boolean isActive) {
        this.stockIDPK = stockIDPK;
        this.quantity = quantity;
        this.bestBefore = bestBefore;
        this.isActive = isActive;
    }

    public Integer getStockIDPK() {
        return stockIDPK;
    }

    public void setStockIDPK(Integer stockIDPK) {
        this.stockIDPK = stockIDPK;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(String bestBefore) {
        this.bestBefore = bestBefore;
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
        hash += (stockIDPK != null ? stockIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodstock)) {
            return false;
        }
        Bloodstock other = (Bloodstock) object;
        if ((this.stockIDPK == null && other.stockIDPK != null) || (this.stockIDPK != null && !this.stockIDPK.equals(other.stockIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bloodstock[ stockIDPK=" + stockIDPK + " ]";
    }
    
}
