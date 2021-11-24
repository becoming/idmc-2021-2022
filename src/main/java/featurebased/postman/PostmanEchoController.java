package featurebased.postman;

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
    public String testGet() {
        return client.testGet();
    }

    @GetMapping("get/feign")
    public String testGetFeign() {
        return feignClient.testGet();
    }
}
