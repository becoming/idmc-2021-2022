package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GamesController {

    private final GameService gameService = null;

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @PostMapping
    public Game create(@RequestBody Game gg) {
        return gameService.create(gg);
    }

}
