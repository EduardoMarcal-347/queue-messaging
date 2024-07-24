package org.marcal.cdi.producers;

import org.marcal.cdi.qualifiers.Persistence;
import org.marcal.models.MessageQueue;
import org.marcal.models.Binding;
import org.marcal.models.Exchange;
import org.marcal.persistence.manager.AeroQueuePersistence;
import org.marcal.persistence.manager.BindingPersistence;
import org.marcal.persistence.manager.ExchangePersistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PersistenceManagerProducer {

    @Produces
    @Persistence
    public AeroQueuePersistence createQueuePersistence() {
        String filename = "/home/eduardo/Imagens/queues.json";
        Class<MessageQueue> clazz = MessageQueue.class;
        return new AeroQueuePersistence(filename, clazz);
    }

    @Produces
    @Persistence
    public ExchangePersistence createExchangePersistence() {
        String filename = "/home/eduardo/Imagens/exchanges.json";
        Class<Exchange> clazz = Exchange.class;
        return new ExchangePersistence(filename, clazz);
    }

    @Produces
    @Persistence
    public BindingPersistence createBindingPersistence() {
        String filename = "/home/eduardo/Imagens/bindings.json";
        Class<Binding> clazz = Binding.class;
        return new BindingPersistence(filename, clazz);
    }

}
