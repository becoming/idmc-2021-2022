package fr.unilorraine.idmc.gamescatalog.partners;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(value = "igdb", url = "${app.games.api.url}")
public interface PartnersFeignClient {

    @PostMapping(value = "/games")
    String getTest(@RequestHeader Map<String, String> headers, @RequestBody String string);
}
