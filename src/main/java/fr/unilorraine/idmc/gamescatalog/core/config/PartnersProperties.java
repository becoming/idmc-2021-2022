package fr.unilorraine.idmc.gamescatalog.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.games.api")
@Getter
@Setter
public class PartnersProperties {
    private String url;
    private String token;
    private String clientid;
}
