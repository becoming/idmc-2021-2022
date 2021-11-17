package fr.unilorraine.idmc.gamescatalog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public Iterable<Game> findAll() {
        return gamesService.findAll();
    }

    @PostMapping
    public Game create(@RequestBody Game gg) {
        return gamesService.create(gg);
    }
}
