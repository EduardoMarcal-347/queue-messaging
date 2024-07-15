package org.marcal.persistence.manager;

import org.marcal.models.AeroQueue;
import org.marcal.persistence.PersistenceWrapper;

import javax.inject.Named;

@Named
public class AeroQueuePersistence extends PersistenceWrapper<AeroQueue> {

    public AeroQueuePersistence(String filename, Class<AeroQueue> clazz) {
        super(filename, clazz);
    }

    public AeroQueuePersistence() {
    }
}
