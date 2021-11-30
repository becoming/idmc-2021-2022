package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.PartnersFeign;
import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoFeignClient;
import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("partners")
@RequiredArgsConstructor
public class PartnersController {

    private final PartnersFeign feignClient;

    @GetMapping("get")
    public String testGetFeign() {
        return feignClient.testGet();
    }
}

