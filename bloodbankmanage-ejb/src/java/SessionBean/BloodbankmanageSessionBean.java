/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionBean;

import Entity.Bloodbank;
import Entity.Bloodcamp;
import Entity.Bloodcamprequest;
import Entity.Bloodrequest;
import Entity.Bloodstock;
import Entity.City;
import Entity.Contactus;
import Entity.Country;
import Entity.Doner;
import Entity.Gallery;
import Entity.State;
import Entity.User;
import Entity.Volunteerapprove;
import Entity.Volunteerrating;
import Entity.Volunteerreq;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class BloodbankmanageSessionBean implements BloodbankmanageSessionBeanLocal {

     @PersistenceContext(unitName = "bloodbankmanage-ejbPU")
    private EntityManager em;
    
    @Override
    public String insertstate(State state) {
        try {
            em.persist(state);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatestate(State state) {
      try {
            State updatestate=em.find(State.class, state.getStateIDPK());
            Country m=em.find(Country.class,state.getCountryIDFK().getCountryIDPK());
            updatestate.setStateIDPK(state.getStateIDPK());
             updatestate.setStateName(state.getStateName());
              updatestate.setCountryIDFK(m);
             
     
               em.persist(updatestate);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletestate(int stateID) {
        try {
              State deleteState=em.find(State.class, stateID);
              deleteState.setIsActive(false);
              em.persist(deleteState);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public State searchstate(int StateID) {
        try {
             State state=em.find(State.class,StateID);
           return state;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<State> showallstate() {
       try {
             List<State> statelist=em.createNamedQuery("State.findAll").getResultList();
       return statelist;
        } catch (Exception e) {
            return null;
        }
    }
    
    //country///////////////////////////////////////////////////////////////////////////////////////////////////////
    
      @Override
    public String insertcountry(Country country) {
        try {
            em.persist(country);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatecountry(Country country) {
        try {
            Country updatecoutry=em.find(Country.class, country.getCountryIDPK());
            updatecoutry.setCountryIDPK(country.getCountryIDPK());
             updatecoutry.setCountryName(country.getCountryName());
             
               em.persist(updatecoutry);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletecountry(int countryID) {
        try {
              Country deleteCountry=em.find(Country.class, countryID);
              deleteCountry.setIsActive(false);
              em.persist(deleteCountry);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public Country searchcountry(int countryID) {
        try {
            Country country = em.find(Country.class,countryID);
            return country;
        } catch(Exception e) {
            return  null;
        }
        
    }

    @Override
    public List<Country> showallcountry() {
       List<Country> countrylist=em.createNamedQuery("Country.findAll").getResultList();
       return countrylist;
    }
    
    
    //city/////////////////////////////////////////////////////////////////////////////////////////////////////
    
     @Override
    public String insertcity(City city) {
        try {
            em.persist(city);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatecity(City city) {
        try {
            City updatecity=em.find(City.class, city.getCityIDPK());
            State m=em.find(State.class,city.getStateIDFK().getStateIDPK());

            updatecity.setCityIDPK(city.getCityIDPK());
             updatecity.setCityName(city.getCityName());
             
                updatecity.setStateIDFK(m);
             
               em.persist(updatecity);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletecity(int cityID) {
        try {
              City deleteCity=em.find(City.class, cityID);
              deleteCity.setIsActive(false);
              em.persist(deleteCity);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public City searchcity(int cityID) {
        try {
            City city = em.find(City.class,cityID);
            return city;
        } catch(Exception e) {
            return  null;
        }
        
    }

    @Override
    public List<City> showallcity() {
       List<City> citylist=em.createNamedQuery("City.findAll").getResultList();
       return citylist;
    }
    
    
    //bloodstock////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      @Override
    public String insertstock(Bloodstock bloodstock) {
        try {
            em.persist(bloodstock);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatestock(Bloodstock bloodstock) {
        try {
            Bloodstock updatestock=em.find(Bloodstock.class, bloodstock.getStockIDPK());
            Bloodbank b=em.find(Bloodbank.class,bloodstock.getBloodBankIDFK().getBloodBankIDPK());

            updatestock.setStockIDPK(bloodstock.getStockIDPK());
             updatestock.setQuantity(bloodstock.getQuantity());
             updatestock.setBestBefore(bloodstock.getBestBefore());
             
             
              updatestock.setBloodBankIDFK(b);
               em.persist(updatestock);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletestock(int bloodstockID) {
        try {
              Bloodstock deletestock=em.find(Bloodstock.class, bloodstockID);
              deletestock.setIsActive(false);
              em.persist(deletestock);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public Bloodstock searchstock(int bloodstockID) {
        try {
            Bloodstock bs = em.find(Bloodstock.class,bloodstockID);
            return bs;
        } catch(Exception e) {
            return  null;
        }
        
    }

    @Override
    public List<Bloodstock> showallstock() {
       List<Bloodstock> stocklist=em.createNamedQuery("Bloodstock.findAll").getResultList();
       return stocklist;
    }
    
    
    //bloodrequest///////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String insertbloodreq(Bloodrequest bloodrequest) {
        try {
            em.persist(bloodrequest);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatebloodreq(Bloodrequest bloodrequest) {
        try {
            Bloodrequest updatebloodrequest=em.find(Bloodrequest.class, bloodrequest.getReqIDPK());
           
            Bloodbank bb=em.find(Bloodbank.class,bloodrequest.getBloodBankIDFK().getBloodBankIDPK());
            updatebloodrequest.setReqIDPK(bloodrequest.getReqIDPK());
            updatebloodrequest.setSname(bloodrequest.getSname());
            updatebloodrequest.setDob(bloodrequest.getDob());
             updatebloodrequest.setReqBloodGrp(bloodrequest.getReqBloodGrp());
             updatebloodrequest.setReqUnit(bloodrequest.getReqUnit());
             updatebloodrequest.setReqDate(bloodrequest.getReqDate());
             updatebloodrequest.setBloodBankIDFK(bb);
             updatebloodrequest.setContact(bloodrequest.getContact());
             updatebloodrequest.setSimageid(bloodrequest.getSimageid());
             
            
     
               em.persist(updatebloodrequest);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletebloodreq(int bloodrequestID) {
         try {
              Bloodrequest deletebloodrequest=em.find(Bloodrequest.class, bloodrequestID);
              deletebloodrequest.setIsActive(false);
              em.persist(deletebloodrequest);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Bloodrequest searchbloodreq(int bloodrequestID) {
         try {
             Bloodrequest request=em.find(Bloodrequest.class,bloodrequestID);
           return request;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Bloodrequest> showallbloodreq() {
        try {
             List<Bloodrequest> requestlist=em.createNamedQuery("Bloodrequest.findAll").getResultList();
       return requestlist;
        } catch (Exception e) {
            return null;
        }
    }
    
    //camprequest/////////////////////////////////////////////////////////////////////////////////////////////

      @Override
    public String insertcampreq(Bloodcamprequest bloodcamprequest) {
         try {
            em.persist(bloodcamprequest);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatecampreq(Bloodcamprequest bloodcamprequest) {
        try {
            Bloodcamprequest updatecamprequest=em.find(Bloodcamprequest.class, bloodcamprequest.getCampReqIDPK());
            City m=em.find(City.class,bloodcamprequest.getCityIDFK().getCityIDPK());
            User u=em.find(User.class,bloodcamprequest.getUserIDFK().getUserIDPK());
            updatecamprequest.setCampReqIDPK(bloodcamprequest.getCampReqIDPK());
             updatecamprequest.setLocation(bloodcamprequest.getLocation());
             updatecamprequest.setApproxDoner(bloodcamprequest.getApproxDoner());
             updatecamprequest.setReqCampDate(bloodcamprequest.getReqCampDate());
                         
             
              updatecamprequest.setCityIDFK(m);
              updatecamprequest.setUserIDFK(u);
            
            
    
               em.persist(updatecamprequest);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletecampreq(int bloodcamprequestID) {
        try {
              Bloodcamprequest deletecamprequest=em.find(Bloodcamprequest.class, bloodcamprequestID);
              deletecamprequest.setIsActive(false);
              em.persist(deletecamprequest);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Bloodcamprequest searchcampreq(int bloodcamprequestID) {
         try {
             Bloodcamprequest camprequest=em.find(Bloodcamprequest.class,bloodcamprequestID);
           return camprequest;
        } catch (Exception e) {
            return null;
        }
    }

   
    @Override
    public List<Bloodcamprequest> showallcampreq() {
         try {
             List<Bloodcamprequest> camprequestlist=em.createNamedQuery("Bloodcamprequest.findAll").getResultList();
       return camprequestlist;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public String updatecampnoti() {
        try {

            int result = em.createNamedQuery("Bloodcamprequest.findByNotify").executeUpdate();
          //  System.out.println("sessionBean..updateinquirynoti()" + result);
            return "updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @Override
    
    public List<Bloodcamprequest> shownoticamp() {
        List<Bloodcamprequest> bloodcampreqlist = em.createNamedQuery("Bloodcamprequest.findByNotifyAll").setMaxResults(4).getResultList();
        return bloodcampreqlist;
    }
    
    //bloodcamp//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
     @Override
    public String insertcamp(Bloodcamp bloodcamp) {
         try {
            em.persist(bloodcamp);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatecamp(Bloodcamp bloodcamp) {
        try {
            Bloodcamp updatecamp=em.find(Bloodcamp.class, bloodcamp.getBloodCampIDPK());
            City ms=em.find(City.class,bloodcamp.getCityIDFK().getCityIDPK());
            
            
            updatecamp.setBloodCampIDPK(bloodcamp.getBloodCampIDPK());
            updatecamp.setOrgname(bloodcamp.getOrgname());
            updatecamp.setOrgcontact(bloodcamp.getOrgcontact());
             updatecamp.setLocation(bloodcamp.getLocation());
             updatecamp.setTiming(bloodcamp.getTiming());
             updatecamp.setCampdate(bloodcamp.getCampdate());
            
             
              updatecamp.setCityIDFK(ms);
             
            
            
     
               em.persist(updatecamp);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletecamp(int bloodcampID) {
        try {
              Bloodcamp deletecamp=em.find(Bloodcamp.class, bloodcampID);
              deletecamp.setIsActive(false);
              em.persist(deletecamp);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Bloodcamp searchcamp(int bloodcampID) {
        try {
             Bloodcamp camp=em.find(Bloodcamp.class,bloodcampID);
           return camp;
        } catch (Exception e) {
            return null;        
        }
    }

    
    @Override
    public List<Bloodcamp> showallcamp() {
         try {
             List<Bloodcamp> camplist=em.createNamedQuery("Bloodcamp.findAll").getResultList();
       return camplist;
        } catch (Exception e) {
            return null;
        }
    }

    
     @Override
    public List<Bloodcamp> showallbysearchcity(int cityIDFK) {
         try {
             List<Bloodcamp> ctlist=em.createNamedQuery("Bloodcamp.findByCityIDFK").setParameter("cityIDFK", cityIDFK).getResultList();
                   return ctlist;
        } catch (Exception e) {
            return null;
        }
    }
    
  //bloodbank///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String insertbank(Bloodbank bloodbank) {
        try {
            em.persist(bloodbank);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatebank( Bloodbank bloodbank) {
         try {
            Bloodbank updatebank=em.find(Bloodbank.class, bloodbank.getBloodBankIDPK());
            City m=em.find(City.class,bloodbank.getCityIDFK().getCityIDPK());
            updatebank.setBloodBankIDPK(bloodbank.getBloodBankIDPK());
             updatebank.setBloodBankName(bloodbank.getBloodBankName());
             updatebank.setBloodBankAddress(bloodbank.getBloodBankAddress());
             updatebank.setContactperson(bloodbank.getContactperson());
             updatebank.setContactnumber(bloodbank.getContactnumber());
             updatebank.setBloodBankPortal(bloodbank.getBloodBankPortal());
            
             
              updatebank.setCityIDFK(m);
     
               em.persist(updatebank);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletebank(int bloodbankID) {
         try {
              Bloodbank deletebank=em.find(Bloodbank.class, bloodbankID);
              deletebank.setIsActive(false);
              em.persist(deletebank);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Bloodbank searchbank(int bloodbankID) {
        try {
             Bloodbank bank=em.find(Bloodbank.class,bloodbankID);
           return bank;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Bloodbank> showallbank() {
          try {
             List<Bloodbank> banklist=em.createNamedQuery("Bloodbank.findAll").getResultList();
       return banklist;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<City> showcitybystate(int id) {
        List<City> cityList = em.createNamedQuery("City.findCityByState").setParameter("stateIDFK", id).getResultList();
        return cityList;
    }

//contactus////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @Override
    public String insertcontact(Contactus contactus) {
        try {
            em.persist(contactus);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatecontact(Contactus contactus) {
         try {
            Contactus updatecon=em.find(Contactus.class, contactus.getCnoIDPK());
            updatecon.setCnoIDPK(contactus.getCnoIDPK());
             updatecon.setCname(contactus.getCname());
             updatecon.setEmail(contactus.getEmail());
             updatecon.setSubject(contactus.getSubject());
             updatecon.setMessage(contactus.getMessage());
     
               em.persist(updatecon);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletecontact(int conID) {
         try {
              Contactus deletecon=em.find(Contactus.class, conID);
              deletecon.setIsActive(false);
              em.persist(deletecon);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Contactus searchcontact(int cnoID) {
        try {
             Contactus con=em.find(Contactus.class,cnoID);
           return con;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Contactus> showallcontactus() {
          try {
             List<Contactus> conlist=em.createNamedQuery("Contactus.findAll").getResultList();
       return conlist;
        } catch (Exception e) {
            return null;
        }
    }
    
 
    
    
    
    
    //doner/////////////////////////////////////////////////////////////////////////////////////
    
     @Override
    public String insertdoner(Doner doner) {
        try {
            em.persist(doner);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatedoner(Doner doner) {
         try {
            Doner updatedoner=em.find(Doner.class, doner.getDonerIDPK());
            User m=em.find(User.class,doner.getUserIDFK().getUserIDPK());
             Bloodcamp b=em.find(Bloodcamp.class,doner.getBloodCampIDFK().getBloodCampIDPK());
            updatedoner.setDonerIDPK(doner.getDonerIDPK());
            updatedoner.setDimageid(doner.getDimageid());
             updatedoner.setBloodQuantity(doner.getBloodQuantity());
             updatedoner.setDateOfDon(doner.getDateOfDon());
              updatedoner.setLastDateOfDon(doner.getLastDateOfDon());
             
               updatedoner.setUserIDFK(m);
                 updatedoner.setBloodCampIDFK(b);
               em.persist(updatedoner);
                
               
               
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletedoner(int donerID) {
         try {
              Doner deletedoner=em.find(Doner.class, donerID);
              deletedoner.setIsActive(false);
              em.persist(deletedoner);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Doner searchdoner(int donerID) {
        try {
             Doner doner=em.find(Doner.class,donerID);
           return doner;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Doner> showalldoner() {
          try {
             List<Doner> donerlist=em.createNamedQuery("Doner.findAll").getResultList();
       return donerlist;
        } catch (Exception e) {
            return null;
        }
    }
    
     @Override
    public List<Doner> showallcountcamp(int bloodcampIDFK) {
         try {
             List<Doner> counttlist=em.createNamedQuery("Doner.findBybloodcamp").setParameter("bloodCampIDFK", bloodcampIDFK).getResultList();
                   return counttlist;
        } catch (Exception e) {
            return null;
        }
    }

//    @Override
//    public List<User> showuserByDoner(int userID) {
// 
//        List<User> donerlist = em.createNamedQuery("Doner.findByUserIDFK").setParameter("userIDFK", userID).getResultList();
//        return donerlist;
//    }    
    
    
    //user//////////////////////////////////////////////////////////////////////////////////////////////
    
     @Override
    public String insertuser(User user) {
        try {
            em.persist(user);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateuser(User user) {
         try {
            User updateuser=em.find(User.class, user.getUserIDPK());
            City c=em.find(City.class,user.getCityIDFK().getCityIDPK());

            updateuser.setUserIDPK(user.getUserIDPK());
             updateuser.setUserAge(user.getUserAge());
             updateuser.setUserGender(user.getUserGender());
             updateuser.setUserEmail(user.getUserEmail());
             updateuser.setUserPassword(user.getUserPassword());
             updateuser.setUserBloodGrp(user.getUserBloodGrp());
             updateuser.setUserContact(user.getUserContact());
             updateuser.setUserLocation(user.getUserLocation()); 
             updateuser.setUserpic(user.getUserpic());
             updateuser.setDate(user.getDate());
             updateuser.setUserType(user.getUserType());

              updateuser.setCityIDFK(c);
              
             
               em.persist(updateuser);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteuser(int userID) {
         try {
              User deleteuser=em.find(User.class, userID);
              deleteuser.setIsActive(false);
              em.persist(deleteuser);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public User searchuser(int userID) {
        try {
             User user=em.find(User.class,userID);
           return user;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<User> showalluser() {
          try {
             List<User> userlist=em.createNamedQuery("User.findAll").getResultList();
       return userlist;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<City> showcitybystateuser(int id) {
        List<City> cityList = em.createNamedQuery("City.findCityByState").setParameter("stateIDFK", id).getResultList();
        return cityList;
    }
    
     @Override
    public List<User> showallbysearch(String userBloodGrp) {
         try {
             List<User> urlist=em.createNamedQuery("User.findByUserBloodGrp").setParameter("userBloodGrp", userBloodGrp).getResultList();
                   return urlist;
        } catch (Exception e) {
            return null;
        }
    }   
    
     @Override
    public User login(String useremail,String password) {
        User am = (User) em.createNamedQuery("User.findByUser").setParameter("userEmail", useremail).setParameter("userPassword", password).getSingleResult();
        return am;
    }
     
     @Override
    public User findmail(String userEmail) {
        try {
            User us = (User) em.createNamedQuery("User.findByUserEmail").setParameter("userEmail", userEmail).getSingleResult();
            return us;
        } catch (Exception e) {
            return null;
        }
    }
    
    //volunteerapporve//////////////////////////////////////////////////////////////////////////////////
    
      @Override
    public String insertvolap(Volunteerapprove volunteerapprove) {
        try {
            em.persist(volunteerapprove);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatevolap(Volunteerapprove volunteerapprove) {
         try {
           Volunteerapprove updatevolap=em.find(Volunteerapprove.class, volunteerapprove.getVolapIDPK());
            User m=em.find(User.class,volunteerapprove.getUserIDFK().getUserIDPK());
             Bloodcamp b=em.find(Bloodcamp.class,volunteerapprove.getBloodCampIDFK().getBloodCampIDPK());
             
                updatevolap.setUserIDFK(m);
                 updatevolap.setBloodCampIDFK(b);
               em.persist(updatevolap);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletevolap(int volapID) {
         try {
              Volunteerapprove deletevolap=em.find(Volunteerapprove.class, volapID);
              deletevolap.setIsActive(false);
              em.persist(deletevolap);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Volunteerapprove searchvolap(int volapID) {
        try {
             Volunteerapprove volunteerapprove=em.find(Volunteerapprove.class,volapID);
           return volunteerapprove;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Volunteerapprove> showallvolunteerapprove() {
          try {
             List<Volunteerapprove> volaplist=em.createNamedQuery("Volunteerapprove.findAll").getResultList();
       return volaplist;
        } catch (Exception e) {
            return null;
        }
    }
    
    //volunteerrating/////////////////////////////////////////////////////////////////////////////
    
     @Override
    public String insertrating(Volunteerrating volunteerrating) {
        try {
            em.persist(volunteerrating);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updaterating(Volunteerrating volunteerrating) {
         try {
           Volunteerrating updatevolrat=em.find(Volunteerrating.class, volunteerrating.getVolRatIDPK());
            User d=em.find(User.class,volunteerrating.getUserIDFK().getUserIDPK());
            Volunteerapprove v =em.find(Volunteerapprove.class,volunteerrating.getVolapIDFK().getVolapIDPK());
           updatevolrat.setRating(volunteerrating.getRating());
             updatevolrat.setMessage(volunteerrating.getMessage());
             
              updatevolrat.setUserIDFK(d);
                updatevolrat.setVolapIDFK(v);
                
               em.persist(updatevolrat);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleterating(int volratID) {
         try {
              Volunteerrating deleterat=em.find(Volunteerrating.class, volratID);
              deleterat.setIsActive(false);
              em.persist(deleterat);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Volunteerrating searchrating(int volratID) {
        try {
             Volunteerrating volunteerrating=em.find(Volunteerrating.class,volratID);
           return volunteerrating;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Volunteerrating> showallvolunteerrating() {
          try {
             List<Volunteerrating> volratlist=em.createNamedQuery("Volunteerrating.findAll").getResultList();
       return volratlist;
        } catch (Exception e) {
            return null;
        }
    }
    
    //volunteerrequest//////////////////////////////////////////////////////////////////////////////////////
    
     @Override
    public String insertvolreq(Volunteerreq volunteerreq) {
        try {
            em.persist(volunteerreq);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatevolreq(Volunteerreq volunteerreq) {
         try {
           Volunteerreq updatevolreq=em.find(Volunteerreq.class, volunteerreq.getVolIDPK());
            User u=em.find(User.class,volunteerreq.getUserIDFK().getUserIDPK());
            Bloodcamp b=em.find(Bloodcamp.class,volunteerreq.getBloodCampIDFK().getBloodCampIDPK());
           updatevolreq.setEmergencyCon(volunteerreq.getEmergencyCon());
             updatevolreq.setPrefferedTime(volunteerreq.getPrefferedTime());
             updatevolreq.setExpierence(volunteerreq.getExpierence());
              
             updatevolreq.setStatus(volunteerreq.getStatus());
              updatevolreq.setUserIDFK(u);
                 updatevolreq.setBloodCampIDFK(b);
               em.persist(updatevolreq);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletevolreq(int volreqID) {
         try {
              Volunteerreq deletevolreq=em.find(Volunteerreq.class, volreqID);
              deletevolreq.setIsActive(false);
              em.persist(deletevolreq);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }   
    }

    @Override
    public Volunteerreq searchvolreq(int volreqID) {
        try {
             Volunteerreq volunteerreq=em.find(Volunteerreq.class,volreqID);
           return volunteerreq;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public List<Volunteerreq> showallvolunteerreq() {
          try {
             List<Volunteerreq> volreqtlist=em.createNamedQuery("Volunteerreq.findAll").getResultList();
       return volreqtlist;
        } catch (Exception e) {
            return null;
        }
    }
    
     @Override
    public String isAvailableStatus(int volIDPK,String status) {
        try {
            Volunteerreq volunteerreq = em.find(Volunteerreq.class, volIDPK);
            
            volunteerreq.setStatus(status);
            em.persist(volunteerreq);
            return "Status Changed!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    
     
    
    
    // gallery//////////////////////////////////////////////////////////////////////////////////

    @Override
    public String insertphoto(Gallery gallery) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updatephoto(Gallery gallery) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String deletephoto(int gid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gallery searchphoto(int gid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Gallery> showallphoto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public List<Bloodrequest> showallbloodrequser(String reqBloodGrp) {
         try {
             List<Bloodrequest> brlist=em.createNamedQuery("Bloodrequest.findByReqBloodGrp").setParameter("reqBloodGrp", reqBloodGrp).getResultList();
                   return brlist;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Bloodrequest searchbloodgrp(String reqBloodGrp) {
         try {
             Bloodrequest request=em.find(Bloodrequest.class,reqBloodGrp);
           return request;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Volunteerreq> showvolreqbyUser(int volreqID) {
 List<Volunteerreq> Volunteerreqlist = em.createNamedQuery("Volunteerreq.findByuserIDFK").setParameter("userIDFK", volreqID).getResultList();
        return Volunteerreqlist;    }

   
   
}
