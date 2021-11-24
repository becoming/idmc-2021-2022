package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
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

    private final GamesService gamesService;

    @GetMapping
    public Iterable<Game> findAll() {
        return gamesService.findAll();
    }

    @PostMapping
    public GameView create(@RequestBody NewGame gg) {
        return gamesService.create(gg);
    }
}
