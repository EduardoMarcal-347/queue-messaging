package org.marcal.persistence.manager;

import org.marcal.models.Exchange;
import org.marcal.persistence.PersistenceWrapper;

import javax.inject.Named;

@Named
public class ExchangePersistence extends PersistenceWrapper<Exchange> {

    public ExchangePersistence(String filename, Class<Exchange> clazz) {
        super(filename, clazz);
    }

    public ExchangePersistence() {
    }
}
