package Entity;

import Entity.Bloodcamp;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Doner.class)
public class Doner_ { 

    public static volatile SingularAttribute<Doner, User> userIDFK;
    public static volatile SingularAttribute<Doner, Bloodcamp> bloodCampIDFK;
    public static volatile SingularAttribute<Doner, String> lastDateOfDon;
    public static volatile SingularAttribute<Doner, String> dimageid;
    public static volatile SingularAttribute<Doner, Integer> donerIDPK;
    public static volatile SingularAttribute<Doner, String> bloodQuantity;
    public static volatile SingularAttribute<Doner, String> dateOfDon;
    public static volatile SingularAttribute<Doner, Boolean> isActive;

}