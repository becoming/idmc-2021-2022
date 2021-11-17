package fr.unilorraine.idmc.gamescatalog.repositories;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Game, Long> {
}


