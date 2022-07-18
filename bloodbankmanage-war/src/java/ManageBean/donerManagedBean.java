/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodcamp;
import Entity.Doner;
import Entity.User;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@Named(value = "donerBean")
@ApplicationScoped
public class donerManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    /**
     * Creates a new instance of donerManagedBean
     */
    
    int donerIDPK,userIDFK,bloodcampIDFK,bloodcampIDPK;
    String bloodquantity,dimageid,dateofdon,lastdateofdon;

    public int getBloodcampIDPK() {
        return bloodcampIDPK;
    }

    public void setBloodcampIDPK(int bloodcampIDPK) {
        this.bloodcampIDPK = bloodcampIDPK;
    }

    public Bloodcamp getBloodcamp() {
        return bloodcamp;
    }

    public void setBloodcamp(Bloodcamp bloodcamp) {
        this.bloodcamp = bloodcamp;
    }
    Part file;
    List<User> userList;
    List<Bloodcamp> bloodcampList;
 
    Bloodcamp bloodcamp = new Bloodcamp();
    Doner doner = new Doner();

    public String getDateofdon() {
        return dateofdon;
    }

    public void setDateofdon(String dateofdon) {
        this.dateofdon = dateofdon;
    }

    public String getLastdateofdon() {
        return lastdateofdon;
    }

    public void setLastdateofdon(String lastdateofdon) {
        this.lastdateofdon = lastdateofdon;
    }
    
   // Date dateofdon;

    public String getDimageid() {
        return dimageid;
    }

    public void setDimageid(String dimageid) {
        this.dimageid = dimageid;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

   

    
   

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getDonerIDPK() {
        return donerIDPK;
    }

    public void setDonerIDPK(int donerIDPK) {
        this.donerIDPK = donerIDPK;
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

    public String getBloodquantity() {
        return bloodquantity;
    }

    public void setBloodquantity(String bloodquantity) {
        this.bloodquantity = bloodquantity;
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

    public Doner getDoner() {
        return doner;
    }

    public void setDoner(Doner doner) {
        this.doner = doner;
    }
    
      @PostConstruct
     public void init(){
        userList = bloodbankmanageSessionBean.showalluser();
        bloodcampList = bloodbankmanageSessionBean.showallcamp();
        
        donerIDPK=0;

    }
     
      public List<Doner> showalldoner() {
        try {
            return bloodbankmanageSessionBean.showalldoner();
        } catch (Exception e) {
            return null;
        }
    }
    
//      public String  showAlldoneruser(int userIDFK) {
//          
//        userList = bloodbankmanageSessionBean.showuserByDoner(userIDFK);
//         return "/Admin/userdetail.xhtml";
//    }
    public String insertdoner_click()
    {
            try {
             InputStream input = file.getInputStream();
            String path = "D:\\sem_practice\\bloodbankmanage\\bloodbankmanage-war\\web\\image\\";
            
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            dimageid = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, dimageid).toPath());
            Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            doner.setDonerIDPK(donerIDPK);
            doner.setDimageid(dimageid);
            doner.setBloodQuantity(bloodquantity);
            doner.setDateOfDon(dateofdon);
            doner.setLastDateOfDon(lastdateofdon);
//              dateofdon = new Date();
//           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//             
//            doner.setDateOfDon(dateFormat.format(dateofdon));
//            
//           lastdateofdon = new Date();
//        
//             
//            doner.setLastDateOfDon(dateFormat.format(lastdateofdon));
            doner.setBloodCampIDFK(bloodcamp);
            doner.setUserIDFK(user);
            doner.setIsActive(true);
           
            
            
          
            bloodbankmanageSessionBean.insertdoner(doner);
            clear();
            return "/Admin/showdoner.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
     public String insertdoneruser_click()
    {
        try {
            
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
             InputStream input = file.getInputStream();
            String path = "D:\\sem_practice\\bloodbankmanage\\bloodbankmanage-war\\web\\image\\";
            
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            dimageid = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, dimageid).toPath());
            
            System.out.println("ManageBean.camprequestManagedBean.insertcamprequestuser_click()"+userSession.getAttribute("userIDPK").toString());

            Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            doner.setDonerIDPK(donerIDPK);
            doner.setDimageid(dimageid);
            doner.setBloodQuantity(bloodquantity);
            doner.setDateOfDon(dateofdon);
            doner.setLastDateOfDon(lastdateofdon);
//              dateofdon = new Date();
//           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//             
//            doner.setDateOfDon(dateFormat.format(dateofdon));
//            
//           lastdateofdon = new Date();
//        
//             
//            doner.setLastDateOfDon(dateFormat.format(lastdateofdon));
            doner.setBloodCampIDFK(bloodcamp);
            doner.setUserIDFK(user);
            doner.setIsActive(true);
           
            
            
          
            bloodbankmanageSessionBean.insertdoner(doner);
            clear();
            if(userSession.getAttribute("userType")=="admin")
             {
               return "/Admin/showdoner.xhtml";
             }
             else
             {
                return "/User/index.xhtml";
             }
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatedoner_click()
    {
        try {
             InputStream input = file.getInputStream();
            String path = "D:\\sem_practice\\bloodbankmanage\\bloodbankmanage-war\\web\\image\\";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            dimageid = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, dimageid).toPath());
         Bloodcamp bloodcamp = bloodbankmanageSessionBean.searchcamp(bloodcampIDFK);
            User user = bloodbankmanageSessionBean.searchuser(userIDFK);
            doner.setDonerIDPK(donerIDPK);
            doner.setDimageid(dimageid);
            doner.setBloodQuantity(bloodquantity);
             doner.setDateOfDon(dateofdon);
            doner.setLastDateOfDon(lastdateofdon);
          
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//             
//            doner.setDateOfDon(dateFormat.format(dateofdon));
//            
//            lastdateofdon = new Date(); 
//            doner.setLastDateOfDon(dateFormat.format(lastdateofdon));
            doner.setBloodCampIDFK(bloodcamp);
            doner.setUserIDFK(user);
            doner.setIsActive(true);
            
            bloodbankmanageSessionBean.updatedoner(doner);
            clear();
            return "/Admin/showdoner.xhtml";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletedoner_click(int donerIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletedoner(donerIDPK);
            return "/Admin/showdoner.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void searchcampdoner_click(int id)
    {
         try {
           
             bloodcampIDFK = id;
            
             
             
             
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
   
    
     
    
    public String searchdoner_click(int id)
    {
        try {
            doner = bloodbankmanageSessionBean.searchdoner(id);
            donerIDPK = doner.getDonerIDPK();
            bloodquantity = doner.getBloodQuantity();
            dimageid = doner.getDimageid();
            userIDFK = doner.getUserIDFK().getUserIDPK();
            bloodcampIDFK = doner.getBloodCampIDFK().getBloodCampIDPK();
            
            return "/Admin/doneradd.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    
    
    
    public void clear(){
        donerIDPK = 0;
        bloodquantity = "";
        dateofdon = null;
        lastdateofdon = null;
        userIDFK = 0;
        bloodcampIDFK = 0;
        dimageid = "";
    }


    
    public donerManagedBean() {
    }
    
}
