package fr.unilorraine.idmc.gamescatalog.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("gamesAPI")
@RequiredArgsConstructor
public class PartnersController {
    @SneakyThrows
    @GetMapping("get")
    public String testGet() {
        var request = HttpRequest.newBuilder()
                .uri(new URI("https://www.freetogame.com/api/games"))
                        .GET()
                        .build();

        var response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}