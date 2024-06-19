package org.marcal.persistence;

import java.util.List;

public interface JsonPersistence <T> {
    List<T> load();
    void save();
    void persist(T t);
}
