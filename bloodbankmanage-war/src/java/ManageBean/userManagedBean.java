/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.City;
import Entity.State;
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
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@Named(value = "userBean")
@ApplicationScoped
public class userManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    /**
     * Creates a new instance of userManagedBean
     */
    
    int userIDPK,cityIDFK,stateIDFK;
    String username,userage,usergender,useremail,userpassword,userbloodgrp,usercontact,userlocation,userpic,usertype;
    List<City> cityList;
    List<State> stateList;

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    List<User> userlist;
   Part file;
    Date date;

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }
  

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
    User user = new User();

  
    
   


    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserbloodgrp() {
        return userbloodgrp;
    }

    public void setUserbloodgrp(String userbloodgrp) {
        this.userbloodgrp = userbloodgrp;
    }

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @PostConstruct  
     public void init(){
       
        stateList = bloodbankmanageSessionBean.showallstate();
        userIDPK = 0;
     }
     
     public void fillCity()
     {
         cityList = bloodbankmanageSessionBean.showcitybystate(stateIDFK);
     }
     
       public List<User> showalluser() {
        try {
            return bloodbankmanageSessionBean.showalluser();
        } catch (Exception e) {
            return null;
        }
    }
//       
//        public String  showAlldoneruser1(int DonerID) {
//          
//        userlist = bloodbankmanageSessionBean.showuserByDoner1(DonerID);
//         return "/Admin/userdetail.xhtml";
//    }
       
        
public String insertadmin_click()
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

            userpic = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, userpic).toPath());
            
            date =new Date();
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
        
            user.setUserIDPK(userIDPK);  
            user.setUserName(username);
            user.setUserAge(userage);
            user.setUserGender(usergender);
            user.setUserEmail(useremail);
            user.setUserPassword(userpassword);
            user.setUserBloodGrp(userbloodgrp);
            user.setUserContact(usercontact);
            user.setUserLocation(userlocation);
            user.setUserpic(userpic);
           
             user.setCityIDFK(city);
            // user.setDate(date);
                user.setDate(dateFormat.format(date));
                user.setUserType(usertype);
             user.setIsActive(true);

            
          
            bloodbankmanageSessionBean.insertuser(user);
          clear();
            
            return "/Admin/showuser.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
       
       public String insertuser_click()
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

            userpic = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, userpic).toPath());
            
            date =new Date();
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
        
            user.setUserIDPK(userIDPK);  
            user.setUserName(username);
            user.setUserAge(userage);
            user.setUserGender(usergender);
            user.setUserEmail(useremail);
            user.setUserPassword(userpassword);
            user.setUserBloodGrp(userbloodgrp);
            user.setUserContact(usercontact);
            user.setUserLocation(userlocation);
            user.setUserpic(userpic);
           
             user.setCityIDFK(city);
            // user.setDate(date);
            user.setUserType("user");
                user.setDate(dateFormat.format(date));
             user.setIsActive(true);

            
          
            bloodbankmanageSessionBean.insertuser(user);
            clear();
           if(userSession.getAttribute("userType")=="admin")
            {
              return "/User/index.xhtml";
            }
            else
            {
                return "/login2.xhtml?faces-redirect=true";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateuser_click()
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

            userpic = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, userpic).toPath());
            
             City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
        
           user.setUserIDPK(userIDPK);
            user.setUserName(username);
            user.setUserAge(userage);
            user.setUserGender(usergender);
            user.setUserEmail(useremail);
            user.setUserPassword(userpassword);
            user.setUserBloodGrp(userbloodgrp);
            user.setUserContact(usercontact);
            user.setUserLocation(userlocation);
            user.setUserpic(userpic);
          //  user.setDate(date);
          //  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
             
         //   user.setDate(dateFormat.format(date));
                 user.setCityIDFK(city);
                    user.setIsActive(true);
            
            bloodbankmanageSessionBean.updateuser(user);
           
            return "/Admin/showuser.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String edituser_click()
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

            userpic = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, userpic).toPath());
            
             City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
        
           user.setUserIDPK(userIDPK);
            user.setUserName(username);
            user.setUserAge(userage);
            user.setUserGender(usergender);
            user.setUserEmail(useremail);
            user.setUserPassword(userpassword);
            user.setUserBloodGrp(userbloodgrp);
            user.setUserContact(usercontact);
            user.setUserLocation(userlocation);
            user.setUserpic(userpic);
          //  user.setDate(date);
          //  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
             
         //   user.setDate(dateFormat.format(date));
                 user.setCityIDFK(city);
                    user.setIsActive(true);
            
            bloodbankmanageSessionBean.updateuser(user);
            
           
            return "/User/newprof.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public String deleteuser_click(int userIDPK)
    {
        try {
            bloodbankmanageSessionBean.deleteuser(userIDPK);
            
            return "/Admin/showuser.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
     public void searchuserprofile_click()
    {
        try {
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                 HttpSession userSession = request.getSession();


            
            user = bloodbankmanageSessionBean.searchuser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
             userIDPK = user.getUserIDPK();
             username = user.getUserName();
             userage = user.getUserAge();
             usergender = user.getUserGender();
             useremail = user.getUserEmail();
             userpassword = user.getUserPassword();
             userbloodgrp = user.getUserBloodGrp();
             usercontact = user.getUserContact();
             userlocation = user.getUserLocation();
             userpic = user.getUserpic();
          //   date = user.getDate();
             
             cityIDFK = user.getCityIDFK().getCityIDPK();
             
           
             
        } catch (Exception e) {
         e.getMessage();
        }
    }
     
     public String fillUser() {
        User usr = new User();

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession();
        
        if (userSession.getAttribute("userIDPK") != null) 
        {

            if (userSession.getAttribute("userType").toString().equalsIgnoreCase("user")) 
            {
                userIDPK = Integer.parseInt(userSession.getAttribute("userIDPK").toString());

                System.out.println("managedBean.userManagedBean.init()" + userIDPK);
                usr = bloodbankmanageSessionBean.searchuser(userIDPK);
                userIDPK = usr.getUserIDPK();
//            username=userSession.getAttribute("userName").toString();
                userIDPK = usr.getUserIDPK();
             username = usr.getUserName();
             userage = usr.getUserAge();
             usergender = usr.getUserGender();
             useremail = usr.getUserEmail();    
             userpassword = usr.getUserPassword();
             userbloodgrp = usr.getUserBloodGrp();
             usercontact = usr.getUserContact();
             userlocation = usr.getUserLocation();
             userpic = usr.getUserpic();
          //   date = user.getDate();
             
             cityIDFK = usr.getCityIDFK().getCityIDPK();
             
            }
        }
        return "/User/test.xhtml?faces-redirect=true";
    }

    
    public String searchuser_click(int id)
    {
        try {
            user = bloodbankmanageSessionBean.searchuser(id);
             userIDPK = user.getUserIDPK();
             username = user.getUserName();
             userage = user.getUserAge();
             usergender = user.getUserGender();
             useremail = user.getUserEmail();
             userpassword = user.getUserPassword();
             userbloodgrp = user.getUserBloodGrp();
             usercontact = user.getUserContact();
             userlocation = user.getUserLocation();
             userpic = user.getUserpic();
          //   date = user.getDate();
             
             cityIDFK = user.getCityIDFK().getCityIDPK();
             
             return "/Admin/useradd.xhtml";
             
        } catch (Exception e) {
          return  e.getMessage();
        }
    }
    
     public List<User> showallbysearch(String userBloodGrp) {
            
                   return bloodbankmanageSessionBean.showallbysearch(userBloodGrp);
    }
    
    public void clear(){
        userIDPK = 0;
         username="";
        userage  = "";
        usergender="";
        useremail ="";
        userpassword = "";
        userbloodgrp = "";
        usercontact = "";
        userlocation = "";
        userpic="";
     // date="";
      
       
        cityIDFK = 0;
    }

    
    public userManagedBean() {
    }
    
}
