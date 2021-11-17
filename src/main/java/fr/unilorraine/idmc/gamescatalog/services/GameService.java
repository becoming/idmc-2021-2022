package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GamesRepository repository;
    public Iterable<Game> findAll(){
        return repository.findAll();
    }
}
