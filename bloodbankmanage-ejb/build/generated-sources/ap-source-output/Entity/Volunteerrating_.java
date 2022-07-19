package Entity;

import Entity.User;
import Entity.Volunteerapprove;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Volunteerrating.class)
public class Volunteerrating_ { 

    public static volatile SingularAttribute<Volunteerrating, User> userIDFK;
    public static volatile SingularAttribute<Volunteerrating, Volunteerapprove> volapIDFK;
    public static volatile SingularAttribute<Volunteerrating, Integer> volRatIDPK;
    public static volatile SingularAttribute<Volunteerrating, String> rating;
    public static volatile SingularAttribute<Volunteerrating, String> message;
    public static volatile SingularAttribute<Volunteerrating, Boolean> isActive;

}