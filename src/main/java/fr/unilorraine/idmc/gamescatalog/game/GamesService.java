package fr.unilorraine.idmc.gamescatalog.game;

import fr.unilorraine.idmc.gamescatalog.game.data.GameView;
import fr.unilorraine.idmc.gamescatalog.game.data.GameRepository;
import fr.unilorraine.idmc.gamescatalog.game.data.NewGame;
import fr.unilorraine.idmc.gamescatalog.core.exceptions.PublisherNotFound;
import fr.unilorraine.idmc.gamescatalog.publisher.data.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GameRepository repo;
    private final PublisherRepository publisherRepo;
    private final GamesMapper mapper;

    public List<GameView> findAll() {
        return mapper.toDto(repo.findAll());
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
