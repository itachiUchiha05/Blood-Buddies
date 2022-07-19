package Entity;

import Entity.City;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Bloodcamprequest.class)
public class Bloodcamprequest_ { 

    public static volatile SingularAttribute<Bloodcamprequest, String> reqCampDate;
    public static volatile SingularAttribute<Bloodcamprequest, User> userIDFK;
    public static volatile SingularAttribute<Bloodcamprequest, Boolean> isRead;
    public static volatile SingularAttribute<Bloodcamprequest, String> location;
    public static volatile SingularAttribute<Bloodcamprequest, City> cityIDFK;
    public static volatile SingularAttribute<Bloodcamprequest, Boolean> isActive;
    public static volatile SingularAttribute<Bloodcamprequest, Integer> campReqIDPK;
    public static volatile SingularAttribute<Bloodcamprequest, String> approxDoner;

}