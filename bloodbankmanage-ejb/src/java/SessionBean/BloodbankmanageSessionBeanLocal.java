/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package SessionBean;

import Entity.City;
import Entity.Country;
import Entity.State;
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
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface BloodbankmanageSessionBeanLocal {
    
    //state
    public String insertstate(State state);
    public String updatestate(State state);
    public String deletestate(int stateID);
    public State searchstate(int StateID);
    public List<State> showallstate();
    
    
    //country
    public String insertcountry(Country country);
    public String updatecountry(Country country);
    public String deletecountry(int countryID);
    public Country searchcountry(int countryID);
    public List<Country> showallcountry();
    
    //city
     public String insertcity(City city);
    public String updatecity(City city);
    public String deletecity(int cityID);
    public City searchcity(int cityID);
    public List<City> showallcity();
    
    
    //bloodstock//////////////////////////////////////////////////////////////////////////////////////////////////////////
    
         public String insertstock(Bloodstock bloodstock);
    public String updatestock(Bloodstock bloodstock);
    public String deletestock(int bloodstockID);
    public Bloodstock searchstock(int bloodstockID);
    public List<Bloodstock> showallstock();
    
    
    //bloodrequest/////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertbloodreq(Bloodrequest bloodrequest);
    public String updatebloodreq(Bloodrequest bloodrequest);
    public String deletebloodreq(int bloodrequestID);
    public Bloodrequest searchbloodreq(int bloodrequestID);  
     public Bloodrequest searchbloodgrp(String reqBloodGrp);
    public List<Bloodrequest> showallbloodreq();
    
    public List<Bloodrequest> showallbloodrequser(String reqBloodGrp);
    
    //camprequest//////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertcampreq(Bloodcamprequest bloodcamprequest);
    public String updatecampreq(Bloodcamprequest bloodcamprequest);
    public String deletecampreq(int bloodcamprequestID);
    public Bloodcamprequest searchcampreq(int bloodcamprequestID); 
    public List<Bloodcamprequest> showallcampreq();
    
      public String updatecampnoti();
     
      public List <Bloodcamprequest> shownoticamp();
    
    //bloodcamp////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertcamp(Bloodcamp bloodcamp);
    public String updatecamp(Bloodcamp bloodcamp);
    public String deletecamp(int bloodcampID);
    public Bloodcamp searchcamp(int bloodcampID);
    public List<Bloodcamp> showallcamp();
    
    public List<Bloodcamp> showallbysearchcity(int cityIDFK);
    
   
     
    
    //bloodbank////////////////////////////////////////////////////////////////////////////////////////////////////////
    
     public String insertbank(Bloodbank bloodbank);
    public String updatebank(Bloodbank bloodbank);
    public String deletebank(int bloodbankID);
    public Bloodbank searchbank(int bloodbankID);
    public List<Bloodbank> showallbank();
    public List<City> showcitybystate(int id);
    
    //contactus/////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertcontact(Contactus contactus);
    public String updatecontact(Contactus contactus);
    public String deletecontact(int cnoID);
    public Contactus searchcontact(int cnoID);
    public List<Contactus> showallcontactus();
    

    
   
    
    //doner/////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertdoner(Doner doner);
    public String updatedoner(Doner doner);
    public String deletedoner(int donerID);
    public Doner searchdoner(int donerID);
    public List<Doner> showalldoner();
  //  public List<User> showuserByDoner(int userID);
    
   public List<Doner> showallcountcamp(int bloodcampIDFK);
    
    //user///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertuser(User user);
    public String updateuser(User user);
    public String deleteuser(int userID);
    public User searchuser(int userID);
    public List<User> showalluser();
    public List<City> showcitybystateuser(int id);
    
  //  public List<User> showuserByDoner1(int DonerID);
    public List<User> showallbysearch(String userBloodGrp);
    
    public User login(String useremail,String password);
    
    public User findmail(String userEmail);
    
    //volunteerapprove///////////////////////////////////////////////////////////////////////////////////
    
    public String insertvolap(Volunteerapprove volunteerapprove);
    public String updatevolap(Volunteerapprove volunteerapprove);
    public String deletevolap(int volapID);
    public Volunteerapprove searchvolap(int volapID);
    public List<Volunteerapprove> showallvolunteerapprove();
    
    //volunteerratings//////////////////////////////////////////////////////////////////////////////////////
    
    public String insertrating(Volunteerrating volunteerrating);
    public String updaterating(Volunteerrating volunteerrating);
    public String deleterating(int volratID);
    public Volunteerrating searchrating(int volratID);
    public List<Volunteerrating> showallvolunteerrating();
    
    //volunteerrequest////////////////////////////////////////////////////////////////////////////////////////////
    
    public String insertvolreq(Volunteerreq volunteerreq);
    public String updatevolreq(Volunteerreq volunteerreq);
    public String deletevolreq(int volreqID);
    public Volunteerreq searchvolreq(int volreqID);
    public List<Volunteerreq> showallvolunteerreq();
    
     public List<Volunteerreq> showvolreqbyUser(int volreqID);
    
    public String isAvailableStatus(int volIDPK,String status);
    
    //galllery//////////////////////////////////////////////////////////////////////////////
    
     public String insertphoto(Gallery gallery);
    public String updatephoto(Gallery gallery);
    public String deletephoto(int gid);
    public Gallery searchphoto(int gid);
    public List<Gallery> showallphoto();
    
}
