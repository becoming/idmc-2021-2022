package fr.unilorraine.idmc.gamescatalog.controllers;

import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("postman-echo")
@RequiredArgsConstructor
public class PostmanEchoController {

    private final PostmanEchoClient client;

    @GetMapping("get")
    public String testGet() {
        return client.testGet();
    }
}
