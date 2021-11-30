package fr.unilorraine.idmc.gamescatalog.controllers;


import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoClient;
import fr.unilorraine.idmc.gamescatalog.client.PostmanEchoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("postman-echo")
@RequiredArgsConstructor
public class PostmanEchoController {

    private final PostmanEchoClient client;
    private final PostmanEchoFeignClient feignClient;

    @GetMapping("get")
    public void getTest(){
        this.client.testGet();
    }

    @GetMapping("get/feign")
    public String getTestFeign(){
        return feignClient.testGet();
    }
}
