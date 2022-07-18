/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodbank;
import Entity.City;
import Entity.State;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Admin
 */
@Named(value = "bloodbankBean")
@ApplicationScoped
public class bloodbankManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    /**
     * Creates a new instance of bloodbankManagedBean
     */
    int bloodbankIDPK,cityIDFK,stateIDFK;
    String bloodbankName,bloodbankAddress,bloodbankportal,bloodbanklocation,contactperson,contactnumber;
    List<City> cityList;
    List<State> stateList;

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
    Date date;

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
    Bloodbank bloodbank = new Bloodbank();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getBloodbankIDPK() {
        return bloodbankIDPK;
    }

    public void setBloodbankIDPK(int bloodbankIDPK) {
        this.bloodbankIDPK = bloodbankIDPK;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public String getBloodbankName() {
        return bloodbankName;
    }

    public void setBloodbankName(String bloodbankName) {
        this.bloodbankName = bloodbankName;
    }

    public String getBloodbankAddress() {
        return bloodbankAddress;
    }

    public void setBloodbankAddress(String bloodbankAddress) {
        this.bloodbankAddress = bloodbankAddress;
    }

    public String getBloodbankportal() {
        return bloodbankportal;
    }

    public void setBloodbankportal(String bloodbankportal) {
        this.bloodbankportal = bloodbankportal;
    }

    public String getBloodbanklocation() {
        return bloodbanklocation;
    }

    public void setBloodbanklocation(String bloodbanklocation) {
        this.bloodbanklocation = bloodbanklocation;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public Bloodbank getBloodbank() {
        return bloodbank;
    }

    public void setBloodbank(Bloodbank bloodbank) {
        this.bloodbank = bloodbank;
    }
    
    
    @PostConstruct
    public void init(){
            stateList = bloodbankmanageSessionBean.showallstate();
        bloodbankIDPK = 0;
    }
     
    public void fillCity()
     {
         cityList = bloodbankmanageSessionBean.showcitybystate(stateIDFK);
     }
     
      public List<Bloodbank> showallbank() {
        try {
            return bloodbankmanageSessionBean.showallbank();
        } catch (Exception e) {
            return null;
        }
    }
      
       public String insertbank_click()
    {
        try {
            City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
            bloodbank.setBloodBankIDPK(bloodbankIDPK);
            bloodbank.setBloodBankName(bloodbankName);
            bloodbank.setBloodBankAddress(bloodbankAddress);
            bloodbank.setContactperson(contactperson);
            bloodbank.setContactnumber(contactnumber);
           
            bloodbank.setBloodBankPortal(bloodbankportal);
           
            bloodbank.setCityIDFK(city);
            bloodbank.setIsActive(true);
             date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
             
           // user.setDate(dateFormat.format(date));           
           
            bloodbankmanageSessionBean.insertbank(bloodbank);
              clear();
              return "/Admin/showbloodbank.xhtml";
        } catch (Exception e) {
             return e.getMessage();
        }
    }
    
    public String updatebank_click()
    {
        try {
           City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
           bloodbank.setBloodBankIDPK(bloodbankIDPK);
            bloodbank.setBloodBankName(bloodbankName);
            bloodbank.setBloodBankAddress(bloodbankAddress);
             bloodbank.setContactperson(contactperson);
            bloodbank.setContactnumber(contactnumber);
            bloodbank.setBloodBankPortal(bloodbankportal);
           
            bloodbank.setCityIDFK(city);
          
            
            bloodbankmanageSessionBean.updatebank(bloodbank);
              clear();
              return "/Admin/showbloodbank.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletebank_click(int bloodbankIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletebank(bloodbankIDPK);
            return "/Admin/showbloodbank.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String searchbank_click(int id)
    {
        try {
            bloodbank = bloodbankmanageSessionBean.searchbank(id);
            bloodbankIDPK = bloodbank.getBloodBankIDPK();
            bloodbankName = bloodbank.getBloodBankName();
            bloodbankAddress = bloodbank.getBloodBankAddress();
            contactperson = bloodbank.getContactperson();
            contactnumber = bloodbank.getContactnumber();
                    
            bloodbankportal = bloodbank.getBloodBankPortal();
            
            cityIDFK = bloodbank.getCityIDFK().getCityIDPK();
            
            return "/Admin/bloodbank.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    
    
    public void clear(){
        bloodbankIDPK = 0;
        bloodbankName = "";
        bloodbankAddress ="";
        contactperson="";
        contactnumber="";
        bloodbankportal ="";
        
        cityIDFK = 0;
    }

    
    
    public bloodbankManagedBean() {
    }
    


    
}
