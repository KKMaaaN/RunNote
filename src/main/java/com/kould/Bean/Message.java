package com.kould.Bean;

public class Message<T> {
    private T message ;
    private String code ;

    public Message(T message, String code) {
        this.message = message ;
        this.code = code ;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
