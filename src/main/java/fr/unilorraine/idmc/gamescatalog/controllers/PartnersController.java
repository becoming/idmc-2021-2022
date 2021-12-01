package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.GameClient;
import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoJDK11Client;
import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("games-echo")
@RequiredArgsConstructor
public class PartnersController {

    private final GameClient feignClient;

    @GetMapping("get")
    public String testGet() {
        return feignClient.testGet();
    }

}
