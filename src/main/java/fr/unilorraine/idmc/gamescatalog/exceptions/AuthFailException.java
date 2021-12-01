package fr.unilorraine.idmc.gamescatalog.exceptions;

import javax.naming.AuthenticationException;

public class AuthFailException extends AuthenticationException {
    public AuthFailException(){
        super("The provided username or password are not correct");
    }
}
