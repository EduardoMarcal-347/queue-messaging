package org.marcal.models;

import java.io.Serializable;
import java.util.Queue;

public class MessageQueue implements Serializable {

    private String queueName;
    private Queue<Object> queue;

    public MessageQueue( String queueName, Queue<Object> queue) {
        this.queueName = queueName;
        this.queue = queue;
    }

    public MessageQueue() {}

    public void enqueue(Object message) {
        this.queue.add(message);
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Queue<Object> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "AeroQueue{" +
                "queueName='" + queueName + '\'' +
                ", messages=" + queue +
                '}';
    }
}
