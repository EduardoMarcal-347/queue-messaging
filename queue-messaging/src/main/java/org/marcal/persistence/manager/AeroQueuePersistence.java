package org.marcal.persistence.manager;

import org.marcal.models.MessageQueue;
import org.marcal.persistence.PersistenceWrapper;

import javax.inject.Named;

@Named
public class AeroQueuePersistence extends PersistenceWrapper<MessageQueue> {

    public AeroQueuePersistence(String filename, Class<MessageQueue> clazz) {
        super(filename, clazz);
    }

    public AeroQueuePersistence() {
    }
}
