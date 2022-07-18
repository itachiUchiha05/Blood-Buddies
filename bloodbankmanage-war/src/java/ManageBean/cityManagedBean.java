/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManageBean;

import SessionBean.BloodbankmanageSessionBeanLocal;
import Entity.City;
import Entity.State;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Admin
 */
@Named(value = "cityBean")
@ApplicationScoped
public class cityManagedBean {

    @EJB
    private BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean;

    /**
     * Creates a new instance of cityManagedBean
     */
    
    int cityIDPK,stateIDFK;
    String cityName,stateName;
    List<State> stateList;
    City city = new City();

    public BloodbankmanageSessionBeanLocal getBloodbankmanageSessionBean() {
        return bloodbankmanageSessionBean;
    }

    public void setBloodbankmanageSessionBean(BloodbankmanageSessionBeanLocal bloodbankmanageSessionBean) {
        this.bloodbankmanageSessionBean = bloodbankmanageSessionBean;
    }

    public int getCityIDPK() {
        return cityIDPK;
    }

    public void setCityIDPK(int cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
     public void init(){
        stateList = bloodbankmanageSessionBean.showallstate();
    }
     
      public List<City> showallcity() {
        try {
            return bloodbankmanageSessionBean.showallcity();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void insertCity_click()
    {
        try {
            State state = bloodbankmanageSessionBean.searchstate(stateIDFK);
            city.setCityIDPK(cityIDPK);
            city.setCityName(cityName);
            city.setStateIDFK(state);
            
            
            city.setStateIDFK(state);
            bloodbankmanageSessionBean.insertstate(state);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void updateCity_click()
    {
        try {
           State state = bloodbankmanageSessionBean.searchstate(stateIDFK);
            city.setCityIDPK(cityIDPK);
            city.setCityName(cityName);
            city.setStateIDFK(state);
            bloodbankmanageSessionBean.updatestate(state);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void deleteCity_click(int cityIDPK)
    {
        try {
            bloodbankmanageSessionBean.deletecity(cityIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void searchCity_click(int id)
    {
        try {
            city = bloodbankmanageSessionBean.searchcity(id);
            cityIDPK = city.getCityIDPK();
            cityName = city.getCityName();
            stateIDFK = city.getStateIDFK().getStateIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    

    public void clear(){
        cityIDPK = 0;
        cityName = "";
        stateIDFK = 0;
    }


    
    public cityManagedBean() {
    }
    
}
