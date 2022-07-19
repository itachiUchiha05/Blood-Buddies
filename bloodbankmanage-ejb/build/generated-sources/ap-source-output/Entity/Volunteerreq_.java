package Entity;

import Entity.Bloodcamp;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Volunteerreq.class)
public class Volunteerreq_ { 

    public static volatile SingularAttribute<Volunteerreq, String> prefferedTime;
    public static volatile SingularAttribute<Volunteerreq, User> userIDFK;
    public static volatile SingularAttribute<Volunteerreq, Integer> volIDPK;
    public static volatile SingularAttribute<Volunteerreq, Bloodcamp> bloodCampIDFK;
    public static volatile SingularAttribute<Volunteerreq, String> emergencyCon;
    public static volatile SingularAttribute<Volunteerreq, String> expierence;
    public static volatile SingularAttribute<Volunteerreq, Boolean> isActive;
    public static volatile SingularAttribute<Volunteerreq, String> status;

}