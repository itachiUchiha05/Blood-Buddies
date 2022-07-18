/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodcamp;
import Entity.User;
import Entity.Volunteerapprove;
import Entity.Volunteerreq;
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
@Named(value = "volreqBean")
@ApplicationScoped
public class volreqManagedBean {
    
    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;
    
    public String getA() {
        return a;
    }
    
    public void setA(String a) {
        this.a = a;
    }
    
    public Volunteerapprove getVolap() {
        return volap;
    }
    
    public void setVolap(Volunteerapprove volap) {
        this.volap = volap;
    }
    
    int volIDPK, userIDFK, bloodcampIDFK,bloodcampIDPK;
    String emergencycon, prefferedtime, expierence, status, a;

    public int getBloodcampIDPK() {
        return bloodcampIDPK;
    }

    public void setBloodcampIDPK(int bloodcampIDPK) {
        this.bloodcampIDPK = bloodcampIDPK;
    }
        
    Volunteerapprove volap = new Volunteerapprove();
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    List<User> userList;
    List<Bloodcamp> bloodcampList;
    Volunteerreq volreq = new Volunteerreq();
    
    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }
    
    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }
    
    public int getVolIDPK() {
        return volIDPK;
    }
    
    public void setVolIDPK(int volIDPK) {
        this.volIDPK = volIDPK;
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
    
    public String getEmergencycon() {
        return emergencycon;
    }
    
    public void setEmergencycon(String emergencycon) {
        this.emergencycon = emergencycon;
    }
    
    public String getPrefferedtime() {
        return prefferedtime;
    }
    
    public void setPrefferedtime(String prefferedtime) {
        this.prefferedtime = prefferedtime;
    }
    
    public String getExpierence() {
        return expierence;
    }
    
    public void setExpierence(String expierence) {
        this.expierence = expierence;
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
    
    public Volunteerreq getVolreq() {
        return volreq;
    }

    /**
     * Creates a new instance of volreqManagedBean
     */
    public void setVolreq(Volunteerreq volreq) {
        this.volreq = volreq;
    }
    
    @PostConstruct
    public void init() {
        userList = bloodbankmanageSessionBean.showalluser();
        bloodcampList = bloodbankmanageSessionBean.showallcamp();
        volIDPK = 0;
        clear();
        
    }
    
    public List<Volunteerreq> showallvolunteerreq() {
        try {
            return bloodbankmanageSessionBean.showallvolunteerreq();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Volunteerreq> filvolireqByuserID() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession userSession = request.getSession();
        return bloodbankmanageSessionBean.showvolreqbyUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
        
    }
    
    public String insertvolreq_click() {
        try {
            Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            volreq.setVolIDPK(volIDPK);
            volreq.setEmergencyCon(emergencycon);
            volreq.setPrefferedTime(prefferedtime);
            volreq.setExpierence(expierence);
            volreq.setBloodCampIDFK(bloodcamp);
            volreq.setUserIDFK(user);
            volreq.setStatus("0");
            volreq.setIsActive(true);
           
            
            bloodbankmanageSessionBean.insertvolreq(volreq);
             clear();
            return "/Admin/showvolreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String checkstatus(String check) {
        System.out.println(check);
        if (check.equals("requested")) {
            System.out.println(check);
            return "0";
        }
        if (check.equals("approve")) {
            System.out.println(check);
            return "1";
        }
        if (check.equals("reject")) {
            System.out.println(check);
            return "2";
        }
        
        return "true";
        
    }
    
    public String insertvolrequser_click() {
        try {
            
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            
            HttpSession userSession = request.getSession();
            
            User user = bloodbankmanageSessionBean.searchuser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            
            Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
//            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            volreq.setVolIDPK(0);
            volreq.setEmergencyCon(emergencycon);
            volreq.setPrefferedTime(prefferedtime);
            volreq.setExpierence(expierence);
            volreq.setBloodCampIDFK(bloodcamp);
            volreq.setUserIDFK(user);
            volreq.setStatus("0");
            volreq.setIsActive(true);
           
            
            bloodbankmanageSessionBean.insertvolreq(volreq);
            clear();
            
             if(userSession.getAttribute("userType")=="admin")
            {
                 
             return "/Admin/showvolreq.xhtml";
            }
            else
            {
                
                return "/User/index.xhtml?faces-redirect=true";
            }
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatevolreq_click() {
        try {
            Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            volreq.setVolIDPK(volIDPK);
            volreq.setEmergencyCon(emergencycon);
            volreq.setPrefferedTime(prefferedtime);
            volreq.setExpierence(expierence);
            volreq.setBloodCampIDFK(bloodcamp);
            volreq.setUserIDFK(user);
            //   a = checkstatus(status);
            volreq.setStatus(status);
            // System.out.println("a=abc"+a);
            volreq.setIsActive(true);
           
            
            bloodbankmanageSessionBean.updatevolreq(volreq);
             clear();
            return "/Admin/showvolreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String status_click(int id) {
        
        try {
            volreq = bloodbankmanageSessionBean.searchvolreq(id);

            // newsIDPK = news.getNewsIDPK();
            volIDPK = volreq.getVolIDPK();

            // newsStatus = news.getNewsStatus();
            //   status = volreq.getStatus();
            status = volreq.getStatus();
            
            volreq.setStatus("1");
            bloodbankmanageSessionBean.updatevolreq(volreq);

//          newsPotalSessionBean.updateNews(news);
            //volreq.setStatus(status);
            return status;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
     public void searchcampvol_click(int id)
    {
         try {
           
             bloodcampIDFK = id;
            
             
             
             
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public String insertvolap_click(Volunteerapprove item) {
        try {
            volap.setVolapIDPK(0);
            volap.setBloodCampIDFK(item.getBloodCampIDFK());
            volap.setUserIDFK(item.getUserIDFK());
            volap.setIsActive(true);
            
            bloodbankmanageSessionBean.insertvolap(volap);
            clear();
            
            return "/Admin/showvolap.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String isAvailable_Click(int volIDPK, String status) {
        try {
            //System.out.println("managedBean.propertyManagedBean.isAvailable_Click()" + isAvailable);
            //  bloodbankmanageSessionBean.isAvailableStatus(propertyIDPK, isAvailable);
            
            bloodbankmanageSessionBean.isAvailableStatus(volIDPK, status);
            volreq = bloodbankmanageSessionBean.searchvolreq(volIDPK);
            if (status.equalsIgnoreCase("1")) {
                volap.setVolapIDPK(0);
                volap.setBloodCampIDFK(volreq.getBloodCampIDFK());
                volap.setUserIDFK(volreq.getUserIDFK());
                volap.setIsActive(true);
                
                bloodbankmanageSessionBean.insertvolap(volap);
            }
            System.out.println("ManageBean.volreqManagedBean.isAvailable_Click()" + volIDPK);
            
            return "/Admin/showvolreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletevolreq_click(int volIDPK) {
        try {
            bloodbankmanageSessionBean.deletevolreq(volIDPK);
            return "/Admin/showvolreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchvolreq_click(int id) {
        try {
            volreq = bloodbankmanageSessionBean.searchvolreq(id);
            volIDPK = volreq.getVolIDPK();
            emergencycon = volreq.getEmergencyCon();
            prefferedtime = volreq.getPrefferedTime();
            expierence = volreq.getExpierence();
            userIDFK = volreq.getUserIDFK().getUserIDPK();
            bloodcampIDFK = volreq.getBloodCampIDFK().getBloodCampIDPK();
            
            return "/Admin/addvolreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void setBloodCampId(int id){
          bloodcampIDFK =id;
    }
    
    public void clear() {
        volIDPK = 0;
        emergencycon = "";
        prefferedtime = "";
        expierence = "";
       
       
    }
    
    public volreqManagedBean() {
    }
    
}
