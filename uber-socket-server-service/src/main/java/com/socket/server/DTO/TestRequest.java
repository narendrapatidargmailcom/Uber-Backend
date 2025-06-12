package com.socket.server.DTO;


public class TestRequest {

    public String data;


    public TestRequest(){

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TestRequest(String data) {
        this.data = data;
    }
}
