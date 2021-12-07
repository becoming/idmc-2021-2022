package fr.unilorraine.idmc.gamescatalog.postman_echo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("postman-echo")
@RequiredArgsConstructor
public class PostmanEchoController {
    private final PostmanEchoJDK11Client jdk11Client;
    private final PostmanEchoFeignClient feignClient;

    @GetMapping("get/jdk11")
    public String testGet() {
        return jdk11Client.testGet();
    }

    @GetMapping("get/feign")
    public String testGetFeign() {
        return feignClient.testGet();
    }
}