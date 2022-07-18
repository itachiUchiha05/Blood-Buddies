/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodcamp;
import Entity.User;
import Entity.Volunteerapprove;
import Entity.Volunteerrating;
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
@Named(value = "volapproveBean")
@ApplicationScoped
public class volapproveManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    /**
     * Creates a new instance of volapproveManagedBean
     */
    
    int volapIDPK,userIDFK,bloodcampIDFK;
    int volratIDPK,volapIDFK;
    String rating,message;

    public List<Volunteerrating> getVolratlist() {
        return volratlist;
    }

    public void setVolratlist(List<Volunteerrating> volratlist) {
        this.volratlist = volratlist;
    }
    
    List<Volunteerrating> volratlist;

    public Volunteerrating getVolrat() {
        return volrat;
    }

    public void setVolrat(Volunteerrating volrat) {
        this.volrat = volrat;
    }

    List<User> userList;
    
    
    Volunteerrating volrat = new Volunteerrating();
            

    public int getVolratIDPK() {
        return volratIDPK;
    }

    public void setVolratIDPK(int volratIDPK) {
        this.volratIDPK = volratIDPK;
    }

    public int getVolapIDFK() {
        return volapIDFK;
    }

    public void setVolapIDFK(int volapIDFK) {
        this.volapIDFK = volapIDFK;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    List<Bloodcamp> bloodcampList;
    Volunteerapprove volap = new Volunteerapprove();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getVolapIDPK() {
        return volapIDPK;
    }

    public void setVolapIDPK(int volapIDPK) {
        this.volapIDPK = volapIDPK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public int getBloodcampIDFK() {
        return bloodcampIDFK;
    }

    public void setBloodcampIDFK(int bloodcampIDFK) {
        this.bloodcampIDFK = bloodcampIDFK;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Bloodcamp> getBloodcampList() {
        return bloodcampList;
    }

    public void setBloodcampList(List<Bloodcamp> bloodcampList) {
        this.bloodcampList = bloodcampList;
    }

    public Volunteerapprove getVolap() {
        return volap;
    }

    public void setVolap(Volunteerapprove volap) {
        this.volap = volap;
    }
    
     public void setvolratbyvolap(int id) {
//        System.out.println("ManagedBean.productManagedBean.setPsubcategoryID()" + id);
        this.volapIDPK = id;

    }
    
    @PostConstruct
      public void init(){
        userList = bloodbankmanageSessionBean.showalluser();
        bloodcampList = bloodbankmanageSessionBean.showallcamp();
        volapIDPK = 0;

    }
     
      public List<Volunteerapprove> showallvolunteerapprove() {
        try {
            return bloodbankmanageSessionBean.showallvolunteerapprove();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertvolap_click()
    {
        try {
            Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            volap.setVolapIDPK(volapIDPK);
             volap.setBloodCampIDFK(bloodcamp);
             volap.setUserIDFK(user);
             volap.setIsActive(true);
             clear();
          
            
            bloodbankmanageSessionBean.insertvolap(volap);
            clear();
             return "/Admin/showvolap.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String updatevolap_click()
    {
        try {
           Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            volap.setVolapIDPK(volapIDPK);
             volap.setBloodCampIDFK(bloodcamp);
             volap.setUserIDFK(user);
             volap.setIsActive(true);
          
             
            bloodbankmanageSessionBean.updatevolap(volap);
               clear();
             return "/Admin/showvolap.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String deletevolap_click(int volapIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletevolap(volapIDPK);
             return "/Admin/showvolap.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String searchvolap_click(int id)
    {
        try {
            volap = bloodbankmanageSessionBean.searchvolap(id);
            volapIDPK = volap.getVolapIDPK();
            userIDFK = volap.getUserIDFK().getUserIDPK();
            
            bloodcampIDFK = volap.getBloodCampIDFK().getBloodCampIDPK();
             return "/Admin/addvolap.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public String insertvolrat_click()
    {
        try {
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            User user = bloodbankmanageSessionBean.searchuser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            
            
            Volunteerapprove volap = bloodbankmanageSessionBean.searchvolap(volapIDPK);
             volrat.setVolRatIDPK(volratIDPK);
             
             volrat.setRating(rating);
             volrat.setMessage(message);
             volrat.setUserIDFK(user);
             volrat.setVolapIDFK(volap);
             volrat.setIsActive(true);

            
          
            bloodbankmanageSessionBean.insertrating(volrat);
            clear();
             if(userSession.getAttribute("userType")=="admin")
            {
             return "/Admin/showvolrat.xhtml";
            }
            else
            {
                return "/User/index.xhtml";
            }

        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public void clear(){
        volapIDPK = 0;
        userIDFK =  0;
        bloodcampIDFK = 0;
       
    }


    
    public volapproveManagedBean() {
    }
    
}
