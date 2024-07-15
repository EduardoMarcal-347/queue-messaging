package org.marcal.models;

import org.marcal.observer.Observer;
import org.marcal.observer.Subject;
import org.marcal.utils.ExchangeType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exchange implements Serializable, Subject {

    private String name;
    private ExchangeType type;
    private boolean durable;
    private boolean  autoDelete;
    private transient List<Observer> observers;

    public Exchange(String name, ExchangeType type, boolean durable, boolean autoDelete) {
        this.name = name;
        this.type = type;
        this.durable = durable;
        this.autoDelete = autoDelete;
        this.observers = new ArrayList<>();
    }

    public Exchange() {}


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void publishMessage(Object message) {
        notifyObservers(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExchangeType getType() {
        return type;
    }

    public void setType(ExchangeType type) {
        this.type = type;
    }

    public boolean isDurable() {
        return durable;
    }

    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    public boolean isAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", durable=" + durable +
                ", autoDelete=" + autoDelete +
                ", observers=" + observers +
                '}';
    }
}
