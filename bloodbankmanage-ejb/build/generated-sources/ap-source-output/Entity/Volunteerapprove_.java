package Entity;

import Entity.Bloodcamp;
import Entity.User;
import Entity.Volunteerrating;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Volunteerapprove.class)
public class Volunteerapprove_ { 

    public static volatile SingularAttribute<Volunteerapprove, User> userIDFK;
    public static volatile SingularAttribute<Volunteerapprove, Bloodcamp> bloodCampIDFK;
    public static volatile SingularAttribute<Volunteerapprove, Integer> volapIDPK;
    public static volatile SingularAttribute<Volunteerapprove, Boolean> isActive;
    public static volatile CollectionAttribute<Volunteerapprove, Volunteerrating> volunteerratingCollection;

}