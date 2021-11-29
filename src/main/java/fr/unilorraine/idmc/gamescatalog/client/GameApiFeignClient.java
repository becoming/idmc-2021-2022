package fr.unilorraine.idmc.gamescatalog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "games", url = "${app.game.feign.url}")
public interface GameApiFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/games?key=522e53d8204e4b0586dfa03c87e2281b")
    String getGames();

}
