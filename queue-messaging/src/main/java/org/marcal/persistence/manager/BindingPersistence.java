package org.marcal.persistence.manager;

import org.marcal.models.Binding;
import org.marcal.persistence.PersistenceWrapper;

import javax.inject.Named;

@Named
public class BindingPersistence extends PersistenceWrapper<Binding> {

    public BindingPersistence(String filename, Class<Binding> clazz) {
        super(filename, clazz);
    }

    public BindingPersistence() {
    }

    @Override
    public void persist(Binding object) {
        data.add(object);
        save();
    }
}
