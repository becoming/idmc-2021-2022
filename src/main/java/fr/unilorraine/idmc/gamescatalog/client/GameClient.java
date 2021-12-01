package fr.unilorraine.idmc.gamescatalog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(value = "games-echo", url = "${app.game.echo-url}")
public interface GameClient {

    @RequestMapping(method = RequestMethod.GET, value = "/games")
    String testGet();

}
