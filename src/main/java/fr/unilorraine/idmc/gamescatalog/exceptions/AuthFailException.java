package fr.unilorraine.idmc.gamescatalog.exceptions;

import org.springframework.security.core.AuthenticationException;

public class AuthFailException extends AuthenticationException {

    public AuthFailException(){
        super("Invalid creditentials");
    }
}
