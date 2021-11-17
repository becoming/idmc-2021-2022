package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.Repositories.GamesRepository;
import fr.unilorraine.idmc.gamescatalog.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GamesRepository repository = null;

    public List<Game> findAll() {
        return null;
    }

    public Game create(Game gg) {
        return repository.save(gg);
    }
}
