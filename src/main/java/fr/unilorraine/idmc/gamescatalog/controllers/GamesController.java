package fr.unilorraine.idmc.gamescatalog.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("games")
@RequiredArgsConstructor
@CrossOrigin(origins = {"*", "localhost", "google.com"})
public class GamesController {

    private final GamesService gamesService;

    @GetMapping
    public List<GameView> findAll() {
        return gamesService.findAll();
    }

    @SneakyThrows
    @GetMapping("/list")
    public String getList(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.freetogame.com/api/games"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameView create(@RequestBody NewGame gg) {
        return gamesService.create(gg);
    }
}
