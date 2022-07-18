/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodcamprequest;
import Entity.City;
import Entity.State;
import Entity.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@Named(value = "camprequestBean")
@ApplicationScoped
public class camprequestManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    int campreqIDPK,userIDFK,cityIDFK,stateIDFK;
     String location,approxdoner;
    List<City> cityList;
    List<User> userList;

    public Date getReqCampDate() {
        return reqCampDate;
    }

    public void setReqCampDate(Date reqCampDate) {
        this.reqCampDate = reqCampDate;
    }
     List<State> stateList;
      Date reqCampDate;
    Bloodcamprequest bloodcamprequest = new Bloodcamprequest();

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
   

    
     public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean(){
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getCampreqIDPK() {
        return campreqIDPK;
    }

    public void setCampreqIDPK(int campreqIDPK) {
        this.campreqIDPK = campreqIDPK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
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

    public String getApproxdoner() {
        return approxdoner;
    }

    public void setApproxdoner(String approxdoner) {
        this.approxdoner = approxdoner;
    }

   

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Bloodcamprequest getBloodcamprequest() {
        return bloodcamprequest;
    }

    /**
     * Creates a new instance of camprequestManagedBean
     */
    public void setBloodcamprequest(Bloodcamprequest bloodcamprequest) {
        this.bloodcamprequest = bloodcamprequest;
    }

    @PostConstruct
    public void init() {
        stateList = bloodbankmanageSessionBean.showallstate();
        userList = bloodbankmanageSessionBean.showalluser();
        campreqIDPK = 0;
//        userIDFK=0;
//         bloodcamprequest = bloodbankmanageSessionBean.searchcampreq(userIDFK);
//             campreqIDPK = bloodcamprequest.getCampReqIDPK();
//             location = bloodcamprequest.getLocation();
//             approxdoner = bloodcamprequest.getApproxDoner();
//             //reqcampdate = bloodcamprequest.getReqCampDate();
//             cityIDFK = bloodcamprequest.getCityIDFK().getCityIDPK();
//             userIDFK = bloodcamprequest.getUserIDFK().getUserIDPK();
    }
     public void fillCity()
     {
         cityList = bloodbankmanageSessionBean.showcitybystate(stateIDFK);
     }
     
       public List<Bloodcamprequest> showallcampreq() {
        try {
            return bloodbankmanageSessionBean.showallcampreq();
        } catch (Exception e) {
            return null;
        }
    }

       
       public String insertcamprequest_click()
    {
        try {
            
            reqCampDate =new Date();
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            bloodcamprequest.setCampReqIDPK(campreqIDPK);
            bloodcamprequest.setUserIDFK(user);
            bloodcamprequest.setLocation(location);
            bloodcamprequest.setCityIDFK(city);
            bloodcamprequest.setApproxDoner(approxdoner);
            bloodcamprequest.setReqCampDate(dateFormat.format(reqCampDate));
            
            // bloodcamprequest.setReqCampDate(reqcampdate);
             bloodcamprequest.setIsRead(true);
             bloodcamprequest.setIsActive(true);
           
             
           
            bloodbankmanageSessionBean.insertcampreq(bloodcamprequest);
              clear();
            
               return "/Admin/showcampreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
       
          public String insertcamprequestuser_click()
    {
        try {
          
            

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
            reqCampDate =new Date();
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            System.out.println("ManageBean.camprequestManagedBean.insertcamprequestuser_click()"+userSession.getAttribute("userIDPK").toString());
            City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
            User user = bloodbankmanageSessionBean.searchuser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            bloodcamprequest.setCampReqIDPK(campreqIDPK);
            bloodcamprequest.setUserIDFK(user);   
            bloodcamprequest.setLocation(location);
            bloodcamprequest.setCityIDFK(city);
            bloodcamprequest.setApproxDoner(approxdoner);
            bloodcamprequest.setReqCampDate(dateFormat.format(reqCampDate));
            
            // bloodcamprequest.setReqCampDate(reqcampdate);
             bloodcamprequest.setIsRead(true);
             bloodcamprequest.setIsActive(true);
             
             
           
            bloodbankmanageSessionBean.insertcampreq(bloodcamprequest);
            clear();
            
             if(userSession.getAttribute("userType")=="admin")
             {
               return "/Admin/showcampreq.xhtml";
             }
             else
             {
                return "/User/index.xhtml";
             }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatecamprequest_click()
    {
        try {
           City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            bloodcamprequest.setCampReqIDPK(campreqIDPK);
            bloodcamprequest.setUserIDFK(user);
            bloodcamprequest.setLocation(location);
            bloodcamprequest.setCityIDFK(city);
            bloodcamprequest.setApproxDoner(approxdoner);
          //  bloodcamprequest.setReqCampDate(reqcampdate);
             bloodcamprequest.setIsRead(true);
             bloodcamprequest.setIsActive(true);
            
            
            bloodbankmanageSessionBean.updatecampreq(bloodcamprequest);
             clear();
                   return "/Admin/showcampreq.xhtml";

        } catch (Exception e) {
           return  e.getMessage();
        }
    }
    
    public String deletecampreq_click(int bloodcampreqIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletecampreq(bloodcampreqIDPK);
            
        return "/Admin/showcampreq.xhtml";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchcampreq_click(int id)
    {
        try {
            bloodcamprequest = bloodbankmanageSessionBean.searchcampreq(id);
             campreqIDPK = bloodcamprequest.getCampReqIDPK();
             location = bloodcamprequest.getLocation();
             approxdoner = bloodcamprequest.getApproxDoner();
             //reqcampdate = bloodcamprequest.getReqCampDate();
             cityIDFK = bloodcamprequest.getCityIDFK().getCityIDPK();
             userIDFK = bloodcamprequest.getUserIDFK().getUserIDPK();
             
               return "/Admin/addcampreq.xhtml";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatecampnoti_Click()
    {
        try {

             bloodbankmanageSessionBean.updatecampnoti();
             
                return "/Admin/showcampreq.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Bloodcamprequest> shownoticamp_click()
    {
        try {
            
            return bloodbankmanageSessionBean.shownoticamp();
        } catch (Exception e) {
            return null;
            
            
        }
    }
    
    public void clear(){
        campreqIDPK = 0;
        location = "";  
        approxdoner  = "";
      
        userIDFK = 0;
        cityIDFK = 0;
    }
    
   
    
    
    public camprequestManagedBean() {
    }
    
}
