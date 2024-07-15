package org.marcal.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class PersistenceWrapper<T> implements JsonPersistence<T>{

    protected Class<T> clazz;
    protected String filename;
    protected Gson gson;
    protected List<T> data;

    public PersistenceWrapper(String filename, Class<T> clazz) {
        this.filename = filename;
        this.clazz = clazz;
        this.gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        this.data = new ArrayList<>();
        if (load() == null) {
            save();
        }
        this.data = load();
    }

    public PersistenceWrapper() {
    }

    @Override
    public List<T> load() {
        try (FileReader reader = new FileReader(this.filename)) {
            Type dataType = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, dataType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @Override
    public void save() {
        try (FileWriter writer = new FileWriter(this.filename)) {
            String json = gson.toJson(data);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void persist(T object) {
        this.data.add(object);
        save();
    }

    public T findByName(String name) {
        AtomicReference<T> objSearched = new AtomicReference<>();
        data.forEach(object -> {
            try {
                Field field = clazz.getDeclaredField("name");
                field.setAccessible(true);
                String objName = field.get(object).toString();
                if (objName.equals(name)) {
                    objSearched.set(object);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        });
        return objSearched.get();
    }

}
