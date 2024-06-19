package org.marcal.cdi.producers;

import org.marcal.cdi.qualifiers.Persistence;
import org.marcal.models.AeroQueue;
import org.marcal.persistence.PersistenceWrapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PersistenceManagerProducer {

    @Produces
    @Persistence(type = "queue")
    public PersistenceWrapper<AeroQueue> createQueuePersistence() {
        String filename = "/home/eduardo/Imagens/queues.json";
        Class<AeroQueue> clazz = AeroQueue.class;
        return new PersistenceWrapper<>(filename, clazz);
    }

    @Produces
    @Persistence(type = "exchange")
    public PersistenceWrapper createExchangePersistence() {
        String filename = "/home/eduardo/Imagens/exchanges.json";
        Class<AeroQueue> clazz = AeroQueue.class;
        return new PersistenceWrapper<>(filename, clazz);
    }

}
