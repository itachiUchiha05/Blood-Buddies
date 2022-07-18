/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Doner;
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
@Named(value = "volratBean")
@ApplicationScoped
public class volratManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    /**
     * Creates a new instance of volratManagedBean
     */
    
    int volratIDPK,userIDFK,volapIDFK,volapIDPK;
    String rating,message;
    List<Doner> donerList;

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public int getVolapIDFK() {
        return volapIDFK;
    }

    public void setVolapIDFK(int volapIDFK) {
        this.volapIDFK = volapIDFK;
    }

    public int getVolapIDPK() {
        return volapIDPK;
    }

    public void setVolapIDPK(int volapIDPK) {
        this.volapIDPK = volapIDPK;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public List<Volunteerapprove> getVolaplist() {
        return volaplist;
    }

    public void setVolaplist(List<Volunteerapprove> volaplist) {
        this.volaplist = volaplist;
    }
    List<User> userlist;
    List<Volunteerapprove> volaplist;
    Volunteerrating volrat = new Volunteerrating();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getVolratIDPK() {
        return volratIDPK;
    }

    public void setVolratIDPK(int volratIDPK) {
        this.volratIDPK = volratIDPK;
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

    public List<Doner> getDonerList() {
        return donerList;
    }

    public void setDonerList(List<Doner> donerList) {
        this.donerList = donerList;
    }

    public Volunteerrating getVolrat() {
        return volrat;
    }

    public void setVolrat(Volunteerrating volrat) {
        this.volrat = volrat;
    }
    
    @PostConstruct
    public void init(){
        donerList = bloodbankmanageSessionBean.showalldoner();
        volratIDPK = 0;
    }
     
      public List<Volunteerrating> showallvolunteerrating() {
        try {
            return bloodbankmanageSessionBean.showallvolunteerrating();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertvolrat_click()
    {
        try {
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            User user = bloodbankmanageSessionBean.searchuser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            
            
            Volunteerapprove volap = bloodbankmanageSessionBean.searchvolap(volapIDFK);
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
    
    public String updatevolrat_click()
    {
        try {
        User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            Volunteerapprove volap = bloodbankmanageSessionBean.searchvolap(volapIDFK);
             volrat.setVolRatIDPK(volratIDPK);
             volrat.setRating(rating);
             volrat.setMessage(message);
             volrat.setUserIDFK(user);
             volrat.setVolapIDFK(volap);
             volrat.setIsActive(true);
            
            bloodbankmanageSessionBean.updaterating(volrat);
            clear();
            return "/Admin/showvolrat.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletevolrat_click(int volratIDPK)
    {
        try {
            bloodbankmanageSessionBean.deleterating(volratIDPK);
            return "/Admin/showvolrat.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String searchvolrat_click(int id)
    {
        try {
            volrat = bloodbankmanageSessionBean.searchrating(id);
            volratIDPK = volrat.getVolRatIDPK();
            userIDFK = volrat.getUserIDFK().getUserIDPK();
            volapIDFK = volrat.getVolapIDFK().getVolapIDPK();
           
            rating = volrat.getRating();
            message = volrat.getMessage();
            
            return "/Admin/addvolrat.xhtml";
      
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        volratIDPK = 0;
        rating = "";
        message="";
        userIDFK = 0;
        volapIDFK = 0;
    }

    public volratManagedBean() {
    }
    
}
