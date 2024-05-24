package org.example.SBA2Q1;

public class CustomException extends Exception {

    public CustomException(String message) {
        // the super keyword passes the message to the constructor
        // of the parent
        super(message);
    }

}
