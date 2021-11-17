package fr.unilorraine.idmc.gamescatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GamesRepository repository;

    public Iterable<Game> findAll() {
        return repository.findAll();
    }

}
