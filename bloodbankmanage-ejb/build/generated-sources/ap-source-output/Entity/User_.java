package Entity;

import Entity.Bloodcamprequest;
import Entity.City;
import Entity.Doner;
import Entity.Volunteerapprove;
import Entity.Volunteerrating;
import Entity.Volunteerreq;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> date;
    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile CollectionAttribute<User, Volunteerapprove> volunteerapproveCollection;
    public static volatile SingularAttribute<User, String> userpic;
    public static volatile SingularAttribute<User, String> userLocation;
    public static volatile SingularAttribute<User, City> cityIDFK;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, String> userContact;
    public static volatile SingularAttribute<User, Boolean> isActive;
    public static volatile CollectionAttribute<User, Doner> donerCollection;
    public static volatile SingularAttribute<User, String> userAge;
    public static volatile CollectionAttribute<User, Volunteerrating> volunteerratingCollection;
    public static volatile SingularAttribute<User, String> userBloodGrp;
    public static volatile CollectionAttribute<User, Bloodcamprequest> bloodcamprequestCollection;
    public static volatile SingularAttribute<User, Integer> userIDPK;
    public static volatile SingularAttribute<User, String> userGender;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile SingularAttribute<User, String> userType;
    public static volatile CollectionAttribute<User, Volunteerreq> volunteerreqCollection;

}