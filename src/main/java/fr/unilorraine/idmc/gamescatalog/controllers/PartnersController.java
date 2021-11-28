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
    @PostMapping("post")
    public String testGet(@RequestBody String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Client-ID", PartnersProperties.getClientID());
        headers.put("Authorization", "Bearer "+ PartnerIGDBClient.getToken());
        headers.put("Content-Type","text/plain");
        return client.testGet(headers, body);
    }
}
