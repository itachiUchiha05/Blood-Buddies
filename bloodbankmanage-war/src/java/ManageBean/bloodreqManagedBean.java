/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import Entity.Bloodbank;
import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodrequest;
import Entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.annotation.PostConstruct;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@Named(value = "bloodreqBean")
@ApplicationScoped
public class bloodreqManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    /**
     * Creates a new instance of bloodreqManagedBean
     */
    int reqIDPK,bloodbankIDFK;
    String sname,dob,reqbloodgrp,requnit,contact,simageid,status,comment;
    List<Bloodbank> blist;
    Part file;
    Date reqdate;
    // Date reqDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReqdate() {
        return reqdate;
    }

    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }

   

    

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    
    Bloodrequest bloodrequest = new Bloodrequest();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getReqIDPK() {
        return reqIDPK;
    }

    public void setReqIDPK(int reqIDPK) {
        this.reqIDPK = reqIDPK;
    }

    public int getBloodbankIDFK() {
        return bloodbankIDFK;
    }

    public void setBloodbankIDFK(int bloodbankIDFK) {
        this.bloodbankIDFK = bloodbankIDFK;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getReqbloodgrp() {
        return reqbloodgrp;
    }

    public void setReqbloodgrp(String reqbloodgrp) {
        this.reqbloodgrp = reqbloodgrp;
    }

    public String getRequnit() {
        return requnit;
    }

    public void setRequnit(String requnit) {
        this.requnit = requnit;
    }

   

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSimageid() {
        return simageid;
    }

    public void setSimageid(String simageid) {
        this.simageid = simageid;
    }

    public List<Bloodbank> getBlist() {
        return blist;
    }

    public void setBlist(List<Bloodbank> blist) {
        this.blist = blist;
    }

    public Bloodrequest getBloodrequest() {
        return bloodrequest;
    }

    public void setBloodrequest(Bloodrequest bloodrequest) {
        this.bloodrequest = bloodrequest;
    }

 
    @PostConstruct
     public void init() {
 
        blist = bloodbankmanageSessionBean.showallbank();
        reqIDPK = 0;
    }
     
       public List<Bloodrequest> showallbloodreq() {
        try {
            return bloodbankmanageSessionBean.showallbloodreq();
        } catch (Exception e) {
            return null;
        }
    }
       
        public List<Bloodrequest> showallbloodrequser(String reqBloodGrp) {
            
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
          
            
            
               return bloodbankmanageSessionBean.showallbloodrequser(userSession.getAttribute("userBloodGrp").toString());
        
    }

       public void sendEmail(String email, String grp, String username) throws IOException, MessagingException {
        String[] to
                = {
                    email
                }; // list of recipient email addresses
        String subject = "Requested Blood Group:" + grp;

        comment =  username + " Requesting you to please help in arranging the blood unit of group '"+ grp + "' , if it is possible then please contact us,Thank You " ;
        String result = intiSendEmail(to, subject, comment);
    }

    public String intiSendEmail(String[] to, String subject, String body) throws IOException, MessagingException {
        String status;
        String USER_NAME = "harshjaguwala@metanoiainfotech.com", PASSWORD = "harsh@2022";
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
            message.setFrom(new InternetAddress(USER_NAME));
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

            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            return status = "Cannot send Message!";
        } catch (MessagingException me) {
            return status = "Cannot send Message!";
        }

        return status = "Message is send!";
    }

        
       public String insertbloodrequest_click()
    {
        try {
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
             reqdate =new Date();
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


           
             InputStream input = file.getInputStream();
            String path = "D:\\sem_practice\\bloodbankmanage\\bloodbankmanage-war\\web\\image\\";
            
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            simageid = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, simageid).toPath());
            
            
            
            Bloodbank bloodbank = bloodbankmanageSessionBean.searchbank(bloodbankIDFK);
            bloodrequest.setReqIDPK(reqIDPK);
            bloodrequest.setSname(sname);
            bloodrequest.setDob(dob);
          
            bloodrequest.setReqUnit(requnit);
            bloodrequest.setReqBloodGrp(reqbloodgrp);
           // bloodrequest.setReqDate(reqdate);
            bloodrequest.setReqDate(dateFormat.format(reqdate));
            bloodrequest.setBloodBankIDFK(bloodbank);
            bloodrequest.setContact(contact);
            bloodrequest.setSimageid(simageid);
                    if(bloodrequest.getReqBloodGrp().equals("A+"))
                    {
                        bloodrequest.setStatus("1");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("A-"))
                    {
                         bloodrequest.setStatus("2");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("B+"))
                    {
                         bloodrequest.setStatus("3");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("B-"))
                    {
                         bloodrequest.setStatus("4");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("O+"))
                    {
                         bloodrequest.setStatus("5");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("O-"))
                    {
                         bloodrequest.setStatus("6");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("AB+"))
                    {
                         bloodrequest.setStatus("7");
                    }
                    if(bloodrequest.getReqBloodGrp().equals("AB-"))
                    {
                         bloodrequest.setStatus("8");
                    }
                    
            
            bloodrequest.setIsActive(true);
            List<User> userList = bloodbankmanageSessionBean.showallbysearch(reqbloodgrp);
            for (int i = 0; i < userList.size(); i++) {
                sendEmail(userList.get(i).getUserEmail(), bloodrequest.getReqBloodGrp(), userList.get(i).getUserName()); 
            }
                    
            bloodbankmanageSessionBean.insertbloodreq(bloodrequest);
            clear();
            
            if(userSession.getAttribute("userType")=="admin")
            {
              return "/Admin/showbloodreq.xhtml";
            }
            else
            {
                return "/User/index.xhtml";
            }
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String updatebloodrequest_click()
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

            simageid = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, simageid).toPath());
           Bloodbank bloodbank = bloodbankmanageSessionBean.searchbank(bloodbankIDFK);
            bloodrequest.setReqIDPK(reqIDPK);
            bloodrequest.setSname(sname);
            bloodrequest.setDob(dob);
           
            bloodrequest.setReqUnit(requnit);
            bloodrequest.setReqBloodGrp(reqbloodgrp);
         //  bloodrequest.setReqDate(reqdate);
            bloodrequest.setBloodBankIDFK(bloodbank);
            bloodrequest.setContact(contact);
            bloodrequest.setSimageid(simageid);
            bloodrequest.setIsActive(true);

            bloodbankmanageSessionBean.updatebloodreq(bloodrequest);
            clear();
            
              return "/Admin/showbloodreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletebloodreq_click(int bloodcampreqIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletebloodreq(bloodcampreqIDPK);
              return "/Admin/showbloodreq.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String searchbloodreq_click(int id)
    {
        try {
            bloodrequest = bloodbankmanageSessionBean.searchbloodreq(id);
             reqIDPK = bloodrequest.getReqIDPK();
             sname = bloodrequest.getSname();
             dob = bloodrequest.getDob();
               reqbloodgrp = bloodrequest.getReqBloodGrp();
             requnit = bloodrequest.getReqUnit();
            // reqdate = bloodrequest.getReqDate();
              bloodbankIDFK = bloodrequest.getBloodBankIDFK().getBloodBankIDPK();
             contact = bloodrequest.getContact();
             simageid = bloodrequest.getSimageid();
             
            
               return "/Admin/addbloodreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchbloodreqgrp_click(String reqBloodGrp)
    {
        try {
            bloodrequest = bloodbankmanageSessionBean.searchbloodgrp(reqBloodGrp);
             reqIDPK = bloodrequest.getReqIDPK();
             sname = bloodrequest.getSname();
             dob = bloodrequest.getDob();
               reqbloodgrp = bloodrequest.getReqBloodGrp();
             requnit = bloodrequest.getReqUnit();
            // reqdate = bloodrequest.getReqDate();
              bloodbankIDFK = bloodrequest.getBloodBankIDFK().getBloodBankIDPK();
             contact = bloodrequest.getContact();
             simageid = bloodrequest.getSimageid();
             
            
               return "/User/newbloodreq.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    
    public void clear(){
        reqIDPK = 0;
        sname ="";
        dob = "";
        reqbloodgrp = "";  
        requnit  = "";
      //  reqdate ="";
        bloodbankIDFK = 0;
        contact = "";
        simageid = "";
       
    }
    
    
    public bloodreqManagedBean() {
    }
    
}
