package fr.unilorraine.idmc.gamescatalog.client;

import fr.unilorraine.idmc.gamescatalog.config.PartnersProperties;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;


@FeignClient(value = "igdb", url = "${app.igdb.feign.games-url}")
public interface PartnerIGDBClient {
    @NonNull
    String TOKEN = getToken();

    static String getToken() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PartnersProperties.getTokenUrl()))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        var resBody = (response != null) ? response.body().split(",")[0].split(":")[1] : "";
        return resBody.substring( 1, resBody.length() - 1 );
    }


    @PostMapping(value = "/games")
    String testGet(@RequestHeader Map<String, String> headerMap, @RequestBody String str);
}
