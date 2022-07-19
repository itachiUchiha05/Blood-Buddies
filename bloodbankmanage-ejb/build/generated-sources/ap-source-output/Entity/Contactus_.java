package Entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Contactus.class)
public class Contactus_ { 

    public static volatile SingularAttribute<Contactus, Integer> cnoIDPK;
    public static volatile SingularAttribute<Contactus, String> subject;
    public static volatile SingularAttribute<Contactus, String> cname;
    public static volatile SingularAttribute<Contactus, String> message;
    public static volatile SingularAttribute<Contactus, Boolean> isActive;
    public static volatile SingularAttribute<Contactus, String> email;

}