package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import fr.unilorraine.idmc.gamescatalog.entities.Game;
import fr.unilorraine.idmc.gamescatalog.exceptions.PublisherNotFound;
import fr.unilorraine.idmc.gamescatalog.mappers.GamesMapper;
import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GamesRepository repo;
    private final PublisherRepository publisherRepo;
    private final GamesMapper mapper;

    public ArrayList<GameView> findAll() {
        var result = new ArrayList<GameView>();
        repo.findAll().forEach(game -> result.add(mapper.toDto(game)) );
        return result;
    }

    public GameView create(NewGame newGame) {
        var gg = mapper.toEntity(newGame);
        var publisher =
                publisherRepo
                        .findById(newGame.getPublisherId())
                        .orElseThrow(() -> PublisherNotFound.of(newGame));

        gg.setPublisher(publisher);
        gg = repo.save(gg);

        return mapper.toDto(gg);
    }
}
