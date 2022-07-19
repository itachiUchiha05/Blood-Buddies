package Entity;

import Entity.City;
import Entity.Doner;
import Entity.Volunteerapprove;
import Entity.Volunteerreq;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Bloodcamp.class)
public class Bloodcamp_ { 

    public static volatile CollectionAttribute<Bloodcamp, Volunteerapprove> volunteerapproveCollection;
    public static volatile SingularAttribute<Bloodcamp, String> orgname;
    public static volatile SingularAttribute<Bloodcamp, String> campdate;
    public static volatile SingularAttribute<Bloodcamp, String> timing;
    public static volatile SingularAttribute<Bloodcamp, String> location;
    public static volatile SingularAttribute<Bloodcamp, City> cityIDFK;
    public static volatile SingularAttribute<Bloodcamp, Boolean> isActive;
    public static volatile CollectionAttribute<Bloodcamp, Doner> donerCollection;
    public static volatile CollectionAttribute<Bloodcamp, Volunteerreq> volunteerreqCollection;
    public static volatile SingularAttribute<Bloodcamp, String> orgcontact;
    public static volatile SingularAttribute<Bloodcamp, Integer> bloodCampIDPK;

}