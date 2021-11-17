package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GamesRepository gamesRepository;

    public Iterable<Game> findAll() {
        return gamesRepository.findAll();
    }

    public Game create(Game gg) {
        return gamesRepository.save(gg);
    }
}
