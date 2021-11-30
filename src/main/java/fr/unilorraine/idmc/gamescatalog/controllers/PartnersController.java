package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.RawgGamesApiFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("partners")
@RequiredArgsConstructor
public class PartnersController {

    private final RawgGamesApiFeignClient feignClient;

    @GetMapping("games")
    public String loadGames() {
        return feignClient.loadGames();
    }


}
