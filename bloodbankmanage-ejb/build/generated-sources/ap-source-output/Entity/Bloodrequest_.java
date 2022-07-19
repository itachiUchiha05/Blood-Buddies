package Entity;

import Entity.Bloodbank;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Bloodrequest.class)
public class Bloodrequest_ { 

    public static volatile SingularAttribute<Bloodrequest, String> reqBloodGrp;
    public static volatile SingularAttribute<Bloodrequest, String> reqUnit;
    public static volatile SingularAttribute<Bloodrequest, String> reqDate;
    public static volatile SingularAttribute<Bloodrequest, String> sname;
    public static volatile SingularAttribute<Bloodrequest, String> dob;
    public static volatile SingularAttribute<Bloodrequest, String> contact;
    public static volatile SingularAttribute<Bloodrequest, Bloodbank> bloodBankIDFK;
    public static volatile SingularAttribute<Bloodrequest, Boolean> isActive;
    public static volatile SingularAttribute<Bloodrequest, Integer> reqIDPK;
    public static volatile SingularAttribute<Bloodrequest, String> simageid;
    public static volatile SingularAttribute<Bloodrequest, String> status;

}