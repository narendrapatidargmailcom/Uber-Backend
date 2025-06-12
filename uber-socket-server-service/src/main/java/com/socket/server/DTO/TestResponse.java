package com.socket.server.DTO;

public class TestResponse {
    public String data;

    public TestResponse(){

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TestResponse(String data) {
        this.data = data;
    }
}
