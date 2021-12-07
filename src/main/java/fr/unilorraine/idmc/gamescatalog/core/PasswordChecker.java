package fr.unilorraine.idmc.gamescatalog.core;

import java.security.NoSuchAlgorithmException;

public interface PasswordChecker {

    boolean areEqual(String source, String target) throws NoSuchAlgorithmException;

}