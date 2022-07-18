/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodcamp;
import Entity.City;
import Entity.Doner;

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
@Named(value = "bloodcampBean")
@ApplicationScoped
public class bloodcampManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    int bloodcampIDPK,cityIDFK,stateIDFK;
    String location,campdate,orgname,orgcontact,timing;
     List<City> cityList;
    List<State> stateList;
    List<Bloodcamp> bloodcamps;

    public int getStateIDFK() {
        return stateIDFK;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }
   
    Bloodcamp bloodcamp = new Bloodcamp();   

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

    public String getCampdate() {
        return campdate;
    }

    public void setCampdate(String campdate) {
        this.campdate = campdate;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<Bloodcamp> getBloodcamps() {
        return bloodcamps;
    }

    public void setBloodcamps(List<Bloodcamp> bloodcamps) {
        this.bloodcamps = bloodcamps;
    }
   
    
    


    
    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getBloodcampIDPK() {
        return bloodcampIDPK;
    }

    public void setBloodcampIDPK(int bloodcampIDPK) {
        this.bloodcampIDPK = bloodcampIDPK;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

   

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

   

    public Bloodcamp getBloodcamp() {
        return bloodcamp;
    }

    public void setBloodcamp(Bloodcamp bloodcamp) {
        this.bloodcamp = bloodcamp;
    }
    
    @PostConstruct
     public void init(){
        cityList = bloodbankmanageSessionBean.showallcity();
        // doctorList = bloodbankmanageSessionBean.showalldoctor();
           stateList = bloodbankmanageSessionBean.showallstate();
      
         bloodcampIDPK = 0;
    }   
     
      public void fillCity()
     {
         cityList = bloodbankmanageSessionBean.showcitybystate(stateIDFK);
     }
     
       public List<Bloodcamp> showallcamp() {
        try {
            return bloodbankmanageSessionBean.showallcamp();
        } catch (Exception e) {
            return null;
        }
        
        
    }
       
       public List<Bloodcamp> showallcampindex() {
        try {
            return bloodbankmanageSessionBean.showallcamp();
        } catch (Exception e) {
            return null;
        }
       }


       
       public String insertcamp_click()
    {
        try {
    
            City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
            
            bloodcamp.setBloodCampIDPK(bloodcampIDPK);
            bloodcamp.setLocation(location);
//            campdate = new Date();
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//             
//            bloodcamp.setCampdate(dateFormat.format(campdate));
            bloodcamp.setOrgname(orgname);
            bloodcamp.setOrgcontact(orgcontact);
            bloodcamp.setCampdate(campdate);
            
            bloodcamp.setTiming(timing);
            bloodcamp.setCityIDFK(city);
            bloodcamp.setIsActive(true);
   
           
            bloodbankmanageSessionBean.insertcamp(bloodcamp);
            clear();
            
            return "/Admin/showbloodcamp.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String updatecamp_click()
    {
        try {
           City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
        
            bloodcamp.setBloodCampIDPK(bloodcampIDPK);
               bloodcamp.setOrgname(orgname);
            bloodcamp.setOrgcontact(orgcontact);
            bloodcamp.setLocation(location);
            bloodcamp.setTiming(timing);
           //  campdate = new Date();
          // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
             
               bloodcamp.setCampdate(campdate);
         
         bloodcamp.setIsActive(true);
            bloodcamp.setCityIDFK(city);
            
            bloodbankmanageSessionBean.updatecamp(bloodcamp);
            clear();
            return "/Admin/showbloodcamp.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletecamp_click(int bloodcampIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletecamp(bloodcampIDPK);
            return "/Admin/showbloodcamp.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
     
    
    public String searchcamp_click(int id)
    {
        try {
           
            bloodcamp = bloodbankmanageSessionBean.searchcamp(id);
             bloodcampIDPK = bloodcamp.getBloodCampIDPK();
             location = bloodcamp.getLocation();
             orgname = bloodcamp.getOrgname();
             orgcontact = bloodcamp.getOrgcontact();
             timing = bloodcamp.getTiming();
             cityIDFK = bloodcamp.getCityIDFK().getCityIDPK();
             
             return "/Admin/bloodcampadd.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public int getDoner(int bloodCampId){
        List<Doner> donerList = bloodbankmanageSessionBean.showallcountcamp(bloodCampId);
        return donerList.size();
    }
    
     public void showallbysearchcity() {
            
                   bloodcamps = bloodbankmanageSessionBean.showallbysearchcity(cityIDFK);
    }
    
    public void clear(){
        bloodcampIDPK = 0;
        orgname = "";
        orgcontact = "";
        location  = "";
        campdate = null;
        timing = "";
        cityIDFK = 0;
    }

    
       
    public bloodcampManagedBean() {
    }
    
}
