package fr.unilorraine.idmc.gamescatalog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "games", url = "${app.rawg.api-url}")
public interface RawgGamesApiFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/games?key=${app.rawg.api-key}")
    String loadGames();

}
