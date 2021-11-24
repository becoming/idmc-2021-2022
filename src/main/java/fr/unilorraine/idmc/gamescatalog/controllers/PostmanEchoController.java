package fr.unilorraine.idmc.gamescatalog.controllers;

        import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoClient;
        import fr.unilorraine.idmc.gamescatalog.dto.GameView;
        import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
        import fr.unilorraine.idmc.gamescatalog.services.GamesService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("postman-echo")
@RequiredArgsConstructor
public class PostmanEchoController {

    private final PostmanEchoClient client;

    @GetMapping("get")
    public String testGet(){
        return client.testGet();
    }

    @GetMapping("get/feign")
    public String testGetFeign(){
        return feignclient.testGet();
    }
}
