package Entity;

import Entity.Bloodrequest;
import Entity.Bloodstock;
import Entity.City;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Bloodbank.class)
public class Bloodbank_ { 

    public static volatile SingularAttribute<Bloodbank, Integer> bloodBankIDPK;
    public static volatile SingularAttribute<Bloodbank, String> contactperson;
    public static volatile CollectionAttribute<Bloodbank, Bloodrequest> bloodrequestCollection;
    public static volatile CollectionAttribute<Bloodbank, Bloodstock> bloodstockCollection;
    public static volatile SingularAttribute<Bloodbank, String> contactnumber;
    public static volatile SingularAttribute<Bloodbank, String> bloodBankAddress;
    public static volatile SingularAttribute<Bloodbank, String> bloodBankPortal;
    public static volatile SingularAttribute<Bloodbank, City> cityIDFK;
    public static volatile SingularAttribute<Bloodbank, Boolean> isActive;
    public static volatile SingularAttribute<Bloodbank, String> bloodBankName;

}