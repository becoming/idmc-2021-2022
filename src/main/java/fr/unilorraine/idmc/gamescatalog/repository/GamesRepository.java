package fr.unilorraine.idmc.gamescatalog.repository;

import fr.unilorraine.idmc.gamescatalog.entities.Games;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends CrudRepository<Games, Long> {

}
