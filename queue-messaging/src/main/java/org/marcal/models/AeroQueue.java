package org.marcal.models;

import java.io.Serializable;
import java.util.Queue;

public class AeroQueue implements Serializable {

    private String queueName;
    private String bindKey;
    private Queue<?> messages;

    public AeroQueue(String queueName, String bindKey, Queue<?> messages) {
        this.queueName = queueName;
        this.bindKey = bindKey;
        this.messages = messages;
    }

    public AeroQueue() {
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getBindKey() {
        return bindKey;
    }

    public void setBindKey(String bindKey) {
        this.bindKey = bindKey;
    }

    public Queue<?> getMessages() {
        return messages;
    }

    public void setMessages(Queue<?> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "AeroQueue{" +
                "queueName='" + queueName + '\'' +
                ", bindKey='" + bindKey + '\'' +
                ", messages=" + messages +
                '}';
    }
}
