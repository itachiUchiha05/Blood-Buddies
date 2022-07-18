/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Country;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Admin
 */
@Named(value = "countryBean")
@ApplicationScoped
public class countryManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;
    
    int countryIDPK;

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getCountryIDPK() {
        return countryIDPK;
    }

    public void setCountryIDPK(int countryIDPK) {
        this.countryIDPK = countryIDPK;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    String countryName;

    
    /**
     * Creates a new instance of countryManagedBean
     */
    public countryManagedBean() {
    }
    
    Country country = new Country();
    
    public void insert_click() {
        try {
            country.setCountryIDPK(0);
            country.setCountryName(countryName);
            
           bloodbankmanageSessionBean.insertcountry(country);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
    
     public void delete_click(int id) {
        try {
            bloodbankmanageSessionBean.deletecountry(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }
     
      public void updateCountry_click()
    {
        try {
            country.setCountryIDPK(countryIDPK);
            country.setCountryName(countryName);
        } catch (Exception e) {
            e.getMessage();
        }
    }
      
      
      public void search_click(int id) {
        try {
            country = bloodbankmanageSessionBean.searchcountry(id);
            countryIDPK = country.getCountryIDPK();
            countryName = country.getCountryName();
        } catch (Exception e) {
            e.getMessage();
        }
    }
     
     public List<Country> showall() {
        return bloodbankmanageSessionBean.showallcountry();
    }
    
}
