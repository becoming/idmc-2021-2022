package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.PartnerIGDBClient;
import fr.unilorraine.idmc.gamescatalog.config.PartnersProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("parteners")
@RequiredArgsConstructor
public class PartnersController {
    private final PartnerIGDBClient client;
    private  Map<String, String> headers;
    @PostMapping("games")
    public String testGet(@RequestBody String body) {
        headers = new HashMap<>();
        headers.put("Client-ID", PartnersProperties.getClientID());
        headers.put("Authorization", "Bearer "+ PartnerIGDBClient.getToken());
        headers.put("Content-Type","text/plain");
        return client.testGet(headers, body);
    }
    @PostMapping("search")
    public String search(@RequestBody String body) {
        headers = new HashMap<>();
        headers.put("Client-ID", PartnersProperties.getClientID());
        headers.put("Authorization", "Bearer "+ PartnerIGDBClient.getToken());
        headers.put("Content-Type","text/plain");
        return client.testGet(headers, body);
    }
}
