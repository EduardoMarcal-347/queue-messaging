package org.marcal.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersistenceWrapper<T> implements JsonPersistence<T>{

    private Class<T> clazz;
    private String filename;
    private Gson gson;
    private List<T> data = new ArrayList<>();

    public PersistenceWrapper(String filename, Class<T> clazz) {
        this.filename = filename;
        this.clazz = clazz;
        this.gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        this.data = load();
    }

    @Override
    public List<T> load() {
        try (FileReader reader = new FileReader(this.filename)) {
            Type dataType = new TypeToken<List<T>>() {}.getType();
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
    public void persist(T data) {
        this.data.add(data);
        save();
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
