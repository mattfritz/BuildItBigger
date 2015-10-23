package com.mattfritz.jokes.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokesBean {

    private String Data;

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}