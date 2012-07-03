package org.saintandreas.serket.impl.orm;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OBJ_TYPE", discriminatorType = javax.persistence.DiscriminatorType.STRING)
public class DIDLObject {
    @Id
    private String id;
    
    @ManyToOne
    private DIDLObject parent;
    
    private String title;
    
    private String didl;
}

