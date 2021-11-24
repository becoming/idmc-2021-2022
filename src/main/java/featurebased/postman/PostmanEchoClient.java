package featurebased.postman;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
@RequiredArgsConstructor
public class PostmanEchoClient {

    private final PostmanProperties postmanProperties;

    @SneakyThrows
    public String testGet(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(postmanProperties.getEchoUrl()))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
