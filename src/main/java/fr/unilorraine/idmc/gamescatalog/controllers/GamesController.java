package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gameService;

    @GetMapping
        public Iterable<Game> findAll(){
        return gameService.findAll();
    }

}
