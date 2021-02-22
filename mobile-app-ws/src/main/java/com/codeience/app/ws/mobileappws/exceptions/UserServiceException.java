package com.codeience.app.ws.mobileappws.exceptions;

//import java.io.Serial;

public class UserServiceException extends RuntimeException{

    //@Serial
    private static final long serialVersionUID = 4949769610342734405L;

    public UserServiceException(String message) {
        super(message);
    }
}
