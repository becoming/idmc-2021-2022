package fr.unilorraine.idmc.gamescatalog.controllers;



import fr.unilorraine.idmc.gamescatalog.entities.Games;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public Iterable<Games> findAll(){
        return gamesService.findAll();
    }

    @PostMapping
    public Games create(@RequestBody Games gg){
        return gamesService.create(gg);
    }
}
