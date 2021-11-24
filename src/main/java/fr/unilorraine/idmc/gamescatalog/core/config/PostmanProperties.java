package fr.unilorraine.idmc.gamescatalog.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.postman")
@Getter
@Setter
public class PostmanProperties {
    private  String echoUrl;
}
