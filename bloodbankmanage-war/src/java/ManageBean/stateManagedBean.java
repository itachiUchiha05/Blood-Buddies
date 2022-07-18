/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.Country;
import Entity.State;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Admin
 */
@Named(value = "stateBean")
@ApplicationScoped
public class stateManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    /**
     * Creates a new instance of stateManagedBean
     */
    int stateIDPK,countryIDFK;
    String stateName,countryName;
    List<Country> countryList;
    State state = new State();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getStateIDPK() {
        return stateIDPK;
    }

    public void setStateIDPK(int stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public void init(){
        countryList = bloodbankmanageSessionBean.showallcountry();
    }
      
    
    public List<State> showallstate() {
        try {
            return bloodbankmanageSessionBean.showallstate();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void insertState_click()
    {
        try {
            Country country = bloodbankmanageSessionBean.searchcountry(countryIDFK);
            state.setStateIDPK(stateIDPK);
            state.setStateName(stateName);
            state.setCountryIDFK(country);
            bloodbankmanageSessionBean.insertstate(state);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void updateState_click()
    {
        try {
            Country country = bloodbankmanageSessionBean.searchcountry(countryIDFK);
            state.setStateIDPK(stateIDPK);
            state.setStateName(stateName);
            state.setCountryIDFK(country);
            bloodbankmanageSessionBean.updatestate(state);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void deleteCity_click(int cityIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletestate(stateIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void searchState_click(int id)
    {
        try {
            state = bloodbankmanageSessionBean.searchstate(id);
            stateIDPK = state.getStateIDPK();
            stateName = state.getStateName();
            countryIDFK = state.getCountryIDFK().getCountryIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void clear(){
        stateIDPK = 0;
        stateName = "";
        countryIDFK = 0;
    }
}

    
   
    
    
    

