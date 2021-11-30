    package fr.unilorraine.idmc.gamescatalog.game;

import fr.unilorraine.idmc.gamescatalog.game.data.GameView;
import fr.unilorraine.idmc.gamescatalog.game.data.NewGame;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public List<GameView> findAll() {
        return gamesService.findAll();
    }

    @PostMapping
    public GameView create(@RequestBody NewGame gg) {
        return gamesService.create(gg);
    }
}
