package fr.unilorraine.idmc.gamescatalog.core;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SHA256Checker implements PasswordChecker {

    @SneakyThrows
    public SHA256Checker() {
        // If this will fail, the app should not boot, it will not work in any case
        MessageDigest.getInstance("SHA-256");
    }

    @SneakyThrows
    public boolean areEqual(String source, String target) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(target.getBytes(StandardCharsets.UTF_8));

        return source.equals(Arrays.toString(hash));
    }
}
