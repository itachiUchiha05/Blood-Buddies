package Entity;

import Entity.Bloodbank;
import Entity.Bloodcamp;
import Entity.Bloodcamprequest;
import Entity.State;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, Integer> cityIDPK;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile CollectionAttribute<City, Bloodbank> bloodbankCollection;
    public static volatile SingularAttribute<City, State> stateIDFK;
    public static volatile CollectionAttribute<City, Bloodcamprequest> bloodcamprequestCollection;
    public static volatile CollectionAttribute<City, User> userCollection;
    public static volatile SingularAttribute<City, Boolean> isActive;
    public static volatile CollectionAttribute<City, Bloodcamp> bloodcampCollection;

}