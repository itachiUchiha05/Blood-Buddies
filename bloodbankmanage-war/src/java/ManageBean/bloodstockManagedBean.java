/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import Entity.Bloodbank;
import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Bloodstock;
import Entity.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Admin
 */
@Named(value = "bloodstockBean")
@ApplicationScoped
public class bloodstockManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    
    int stockIDPK,bloodbankIDFK;
    String quanity,bestbefore;
    List<User> userList;
    List<Bloodbank> blist;

    public List<Bloodbank> getBlist() {
        return blist;
    }

    public void setBlist(List<Bloodbank> blist) {
        this.blist = blist;
    }
    Bloodstock bloodstock = new Bloodstock();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getStockIDPK() {
        return stockIDPK;
    }

    public void setStockIDPK(int stockIDPK) {
        this.stockIDPK = stockIDPK;
    }

    public int getBloodbankIDFK() {
        return bloodbankIDFK;
    }

    public void setBloodbankIDFK(int bloodbankIDFK) {
        this.bloodbankIDFK = bloodbankIDFK;
    }

   

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }

    public String getBestbefore() {
        return bestbefore;
    }

    public void setBestbefore(String bestbefore) {
        this.bestbefore = bestbefore;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Bloodstock getBloodstock() {
        return bloodstock;
    }

    public void setBloodstock(Bloodstock bloodstock) {
        this.bloodstock = bloodstock;
    }

    
    
  
    @PostConstruct
      public void init() {
   
       
        blist = bloodbankmanageSessionBean.showallbank();
       
         stockIDPK = 0;
    }
     
       public List<Bloodstock> showallstock() {
        try {
            return bloodbankmanageSessionBean.showallstock();
        } catch (Exception e) {
            return null;
        }
    }

       
       public String insertstock_click()
    {
        try {
           
            Bloodbank bloodbank = bloodbankmanageSessionBean.searchbank(bloodbankIDFK);
         bloodstock.setStockIDPK(stockIDPK);
            bloodstock.setQuantity(quanity);
            bloodstock.setBestBefore(bestbefore);
            bloodstock.setBloodBankIDFK(bloodbank);
            bloodstock.setIsActive(true);

                    
            bloodbankmanageSessionBean.insertstock(bloodstock);
            clear();
            
              return "/Admin/showstock.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatestock_click()
    {
        try {
          
            Bloodbank bloodbank = bloodbankmanageSessionBean.searchbank(bloodbankIDFK);
            bloodstock.setStockIDPK(stockIDPK);
            bloodstock.setQuantity(quanity);
            bloodstock.setBestBefore(bestbefore);
            bloodstock.setBloodBankIDFK(bloodbank);
             bloodstock.setIsActive(true);
          
            
            bloodbankmanageSessionBean.updatestock(bloodstock);
            clear();
            
             return "/Admin/showstock.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String deletestock_click(int stockIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletestock(stockIDPK);
             return "/Admin/showstock.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public String searchstock_click(int id)
    {
        try {
            bloodstock = bloodbankmanageSessionBean.searchstock(id);
             stockIDPK = bloodstock.getStockIDPK();
             quanity = bloodstock.getQuantity();
             bestbefore = bloodstock.getBestBefore();
            
             bloodbankIDFK = bloodstock.getBloodBankIDFK().getBloodBankIDPK();
             
              return "/Admin/addstock.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    
    public void clear(){
        stockIDPK = 0;
        quanity = "";  
        bestbefore  = "";
        bloodbankIDFK = 0;
       
    }
    

    public bloodstockManagedBean() {
    }
    
}
