package com.google.jplurk_oauth.skeleton;

@SuppressWarnings("serial")
public class RequestException extends Exception {

    public RequestException(Exception e) {
        super(e);
    }

    public RequestException(String message) {
        super(message);
    }

}
