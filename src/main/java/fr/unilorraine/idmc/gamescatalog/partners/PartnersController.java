package fr.unilorraine.idmc.gamescatalog.partners;

import fr.unilorraine.idmc.gamescatalog.core.config.PartnersProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("partners")
@RequiredArgsConstructor
public class PartnersController {
    private String jwt;
    private final PartnersProperties properties;
    private final PartnersFeignClient gamesClient;

    @GetMapping
    public String getTest() {
        Map<String, String> headers = new HashMap<>() {{
            String auth = getAuth(properties.getToken());
            put("Client-ID", properties.getClientid());
            put("Authorization", "Bearer " + auth);
            put("Content-Type", "text/plain");
        }};
        return gamesClient.getTest(headers, "fields *;");
    }

    @SneakyThrows
    public String getAuth(String token) {
        if (jwt == null) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(token))
                    .POST(HttpRequest.BodyPublishers.ofString(""))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String res = response.body().split(",")[0].split(":")[1];
            String substring = res.substring(1, res.length() - 1);
            jwt = substring;
            return substring;
        } else {
            return jwt;
        }
    }
}
