/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Contactus;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Admin
 */
@Named(value = "contactusBean")
@ApplicationScoped
public class contactusManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    /**
     * Creates a new instance of contactusManagedBean
     */
    int cnoIDPK;
    String cname,email,subject,message;
    Contactus contactus = new Contactus();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getCnoIDPK() {
        return cnoIDPK;
    }

    public void setCnoIDPK(int cnoIDPK) {
        this.cnoIDPK = cnoIDPK;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contactus getContactus() {
        return contactus;
    }

    public void setContactus(Contactus contactus) {
        this.contactus = contactus;
    }
     public List<Contactus> showallcontact() {
        try {
            return bloodbankmanageSessionBean.showallcontactus();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void insertContact_click()
    {
        try {
            
            contactus.setCnoIDPK(cnoIDPK);
            contactus.setEmail(email);
            contactus.setSubject(subject);
            contactus.setMessage(message);
                  
            bloodbankmanageSessionBean.insertcontact(contactus);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void updatecontact_click()
    {
        try {
            contactus.setCnoIDPK(cnoIDPK);
            contactus.setEmail(email);
            contactus.setSubject(subject);
            contactus.setMessage(message);
            bloodbankmanageSessionBean.updatecontact(contactus);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void deletecontact_click(int cnoIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletecontact(cnoIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void searchcontact_click(int id)
    {
        try {
            contactus = bloodbankmanageSessionBean.searchcontact(id);
            cnoIDPK = contactus.getCnoIDPK();
            cname = contactus.getCname();
            email = contactus.getEmail();
            message = contactus.getMessage();
            subject = contactus.getSubject();
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void clear(){
        cnoIDPK = 0;
        cname = "";
        subject = "";
        message ="";
    }


    
    
    public contactusManagedBean() {
    }
    
}
