package org.saintandreas.serket.impl.orm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DIDLObject {
    @Id
    String id;
    
    @ManyToOne
    DIDLObject parent;
    
    String title;
    
    String didl;
}

