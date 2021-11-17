package fr.unilorraine.idmc.gamescatalog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.unilorraine.idmc.gamescatalog.entities.Game;

@Repository
public interface GamesRepository extends CrudRepository<Game, Long> {

}
