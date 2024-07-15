package org.marcal.models;

import org.marcal.observer.Observer;

import java.io.Serializable;

public class Binding implements Serializable, Observer {

    private Exchange exchange;
    private AeroQueue queue;
    private String routingKey;

    public Binding(Exchange exchange, AeroQueue queue, String routingKey) {
        this.exchange = exchange;
        this.queue = queue;
        this.routingKey = routingKey;
    }

    public Binding() {
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public AeroQueue getQueue() {
        return queue;
    }

    public void setQueue(AeroQueue queue) {
        this.queue = queue;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public void update(Object message) {
        this.queue.enqueue(message);
        System.out.println("Nova mensagem na fila " + this.queue.getQueueName()+ ": " + message);
    }
}
