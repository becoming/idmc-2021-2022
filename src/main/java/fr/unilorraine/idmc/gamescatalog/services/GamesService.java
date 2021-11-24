package fr.unilorraine.idmc.gamescatalog.services;


import fr.unilorraine.idmc.gamescatalog.entities.Game;

import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import fr.unilorraine.idmc.gamescatalog.exceptions.PublisherNotFound;
import fr.unilorraine.idmc.gamescatalog.mappers.GamesMapper;
import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GamesService {


    private final GamesRepository gamesRepository;
    private final PublisherRepository publisherRepo;
    private final GamesMapper mapper;

    public Iterable<GameView> findAll(){
        return () -> StreamSupport.stream(gamesRepository.findAll().spliterator(), false)
                .map(mapper::toDto).iterator();
    }



    public GameView create(NewGame newGame) {
        var gg = mapper.toEntity(newGame);
        var publisher =
                publisherRepo
                        .findById(newGame.getPublisherId())
                        .orElseThrow(() -> PublisherNotFound.of(newGame));

        gg.setPublisher(publisher);
        gg = gamesRepository.save(gg);

        return mapper.toDto(gg);
    }
}
