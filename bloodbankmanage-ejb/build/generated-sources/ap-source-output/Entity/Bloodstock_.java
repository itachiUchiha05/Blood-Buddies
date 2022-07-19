package Entity;

import Entity.Bloodbank;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-07-06T17:18:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Bloodstock.class)
public class Bloodstock_ { 

    public static volatile SingularAttribute<Bloodstock, Integer> stockIDPK;
    public static volatile SingularAttribute<Bloodstock, String> quantity;
    public static volatile SingularAttribute<Bloodstock, String> bestBefore;
    public static volatile SingularAttribute<Bloodstock, Bloodbank> bloodBankIDFK;
    public static volatile SingularAttribute<Bloodstock, Boolean> isActive;

}