package fr.unilorraine.idmc.gamescatalog.postman_echo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class PostmanEchoJDK11Client {
    private final PostmanProperties postmanProperties;

    @SneakyThrows
    public String testGet() {
        var request = HttpRequest
                              .newBuilder()
                              .uri(new URI(postmanProperties.getEchoUrl()))
                              .GET()
                              .build();
        var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
