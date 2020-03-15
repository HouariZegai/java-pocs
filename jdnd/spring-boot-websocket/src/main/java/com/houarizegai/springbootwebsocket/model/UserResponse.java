package com.houarizegai.springbootwebsocket.model;

public class UserResponse { // message wrapper class
    private String content;

    public UserResponse() {
    }

    public UserResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
