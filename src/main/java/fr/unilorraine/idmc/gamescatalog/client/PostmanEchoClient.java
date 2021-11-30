package fr.unilorraine.idmc.gamescatalog.client;


import fr.unilorraine.idmc.gamescatalog.config.PostmanProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class PostmanEchoClient {


    @Value("${app.postman.echo-url}")
    private String echoUrl;

    @SneakyThrows
    public String testGet() {
        var request = HttpRequest.newBuilder()
                .uri(new URI(echoUrl))
                .GET()
                .build();

        var response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
