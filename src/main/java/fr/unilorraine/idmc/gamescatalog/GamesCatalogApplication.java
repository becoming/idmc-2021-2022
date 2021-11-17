package fr.unilorraine.idmc.gamescatalog;

import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import fr.unilorraine.idmc.gamescatalog.services.GamesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamesCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesCatalogApplication.class, args);
	}

//	@Bean
//	public GamesService gameService(GamesRepository repo){
//		return new GamesService(repo);
//	}

}
