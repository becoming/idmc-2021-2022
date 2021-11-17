package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.entities.Games;
import fr.unilorraine.idmc.gamescatalog.repository.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamesService {
    private final GamesRepository repository;

    public Iterable<Games> findAll() {
        return repository.findAll();
    }

    public Games create(Games gg) {
        return repository.save(gg);
    }
}
