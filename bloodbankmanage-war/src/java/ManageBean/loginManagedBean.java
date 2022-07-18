/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import Entity.City;
import Entity.State;
import Entity.User;
import SessionBean.BloodbankmanageSessionBeanLocal;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@Named(value = "loginManagedBean")
@ApplicationScoped
public class loginManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    int userIDPK,cityIDFK,stateIDFK;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    String useremail, password,userType,userpic,comment,emailmessage, username,userage,usergender,userbloodgrp,usercontact,userlocation,usertype,date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

        List<City> cityList;
         List<State> stateList;

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
        
          User user = new User();

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
    
    public String getUserpic() {
        return userpic;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmailmessage() {
        return emailmessage;
    }

    public void setEmailmessage(String emailmessage) {
        this.emailmessage = emailmessage;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }



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

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void fillCity()
     {
         cityList = bloodbankmanageSessionBean.showcitybystate(stateIDFK);
     }
    

    public String login() {
        try {
            User am = bloodbankmanageSessionBean.login(useremail,password);

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();

            userSession.setAttribute("userIDPK", am.getUserIDPK());
            userSession.setAttribute("userName", am.getUserName());
            userSession.setAttribute("userAge", am.getUserAge());
            userSession.setAttribute("userGender", am.getUserGender());
            userSession.setAttribute("userEmail", am.getUserEmail());
            userSession.setAttribute("userPassword",am.getUserPassword());
            userSession.setAttribute("userBloodGrp", am.getUserBloodGrp());
            userSession.setAttribute("userContact", am.getUserContact());
            userSession.setAttribute("userLocation", am.getUserLocation());
             userSession.setAttribute("userpic", am.getUserpic());
            userSession.setAttribute("cityIDFK", am.getCityIDFK().getCityName());
            
            userSession.setAttribute("userType", am.getUserType());
            userSession.setAttribute("Date", am.getDate());
           

            //String authIDPK =  (String) userSession.getAttribute("authIDPK");
//            if(am.getUserName().equals("admin") && am.getUserPassword().equals("admin") ) 
            if (am.getUserType().equals("admin")) {
                return "/Admin/index.xhtml?faces-redirect=true";
               

            } else if(am.getUserType().equals("user")) {
                return "/User/index.xhtml?faces-redirect=true";

            }

        } catch (Exception e) {
            String message = e.getMessage();
        }
        return null;
    }

    public String logout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession userSession = request.getSession();
            userSession.invalidate();
          //  if(Session.getattribute("userName") == null;
           
           // if(userSession.getAttribute(username).equals(""))        
            
//            if(userSession.getAttribute("userName")==null)
//      response.sendRedirect("login/login.html");
               
               
                    return "/index.xhtml?faces-redirect=true";
               
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }   
    
  public void sendEmail(String email, String desc, String sub) throws IOException, MessagingException  {
        String[] to
                = {
                    email
                };
        
// list of recipient email addresses
        String subject = "Change Password:" + sub;
      String comment;
        comment = "Your Description :" + desc;
        String result = intiSendEmail(to, subject, comment);
        System.err.println("Email ++ "+result);
    }

   public String intiSendEmail(String[] to, String subject, String body) throws IOException, MessagingException {
        String status;
        String USER_NAME = "komalpatel@metanoiainfotech.com", PASSWORD = "komal@2022";
        Properties props = System.getProperties();
        String host = "mail.metanoiainfotech.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME,"bloodbankmanage"));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress toAddres : toAddress) {
                message.addRecipient(Message.RecipientType.TO, toAddres);
            }

            message.setSubject(subject);
            message.setText(body);
            message.setContent(body, "text/html;charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            System.out.println("managedBean.loginManagedBean.intiSendEmail()"+ae);
            return status = "Cannot send Message!";
        } catch (MessagingException me) {
            System.out.println("managedBean.loginManagedBean.intiSendEmail()"+me);
            return status = "Cannot send Message!";
        }

        return status = "Message is send!";
    }
    public String forgotPassword(){
        try {
            
            User us = bloodbankmanageSessionBean.findmail(useremail);
           
            System.out.println("ManagedBean.loginManagedBean.forgotPassword()"+useremail);
            if (getUseremail().equalsIgnoreCase(useremail)) {
                System.out.println("ManagedBean.loginManagedBean.forgotPassword()"+useremail);

               
                comment = "<h4>Change Your Password Through Below Link</h4>"
                        + "<a href='http://localhost:8080/bloodbankmanage-war/forgetpass.xhtml'>Click link to change password</a>";
                sendEmail(useremail, comment, "Forgot Password");
                emailmessage="";
            } else {
                emailmessage = "Email is not valid";
                return "/forgetpassword.xhtml?faces-redirect=true";
            }
           
        } catch (Exception e) {
            return emailmessage="Email is not valid";
        }
        return "/login2.xhtml?faces-redirect=true";
    }
      public String updatepass_click()
    {
        try {
             User us = bloodbankmanageSessionBean.findmail(useremail);
            System.out.println("ManagedBean.loginManagedBean.updatepass_click()"+us);
          
              City city = bloodbankmanageSessionBean.searchcity(cityIDFK);
          
            user.setUserIDPK(us.getUserIDPK());
            user.setUserName(us.getUserName());
            user.setUserAge(us.getUserAge());
            user.setUserGender(us.getUserGender());
            user.setUserEmail(us.getUserEmail());
            user.setUserPassword(password);
            user.setUserBloodGrp(us.getUserBloodGrp());
            user.setUserContact(us.getUserContact());
            user.setUserLocation(us.getUserLocation());
             user.setUserType("user");
             user.setUserpic(us.getUserpic());
           
            user.setDate(us.getDate());
          //  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
             
         //   user.setDate(dateFormat.format(date));
         user.setCityIDFK(us.getCityIDFK());
               //  user.setCityIDFK(us.getCityIDFK());
                    user.setIsActive(true);
            
            bloodbankmanageSessionBean.updateuser(user);
   
         return "/login2.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
        
    }
    
    public loginManagedBean() {
    }

}
