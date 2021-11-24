package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.dto.GameView;
import fr.unilorraine.idmc.gamescatalog.dto.NewGame;
import fr.unilorraine.idmc.gamescatalog.dto.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.dto.PublisherView;
import fr.unilorraine.idmc.gamescatalog.entities.Publisher;
import fr.unilorraine.idmc.gamescatalog.exceptions.PublisherNotFound;
import fr.unilorraine.idmc.gamescatalog.mappers.PublishersMapper;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PublishersService {

    private final PublisherRepository repo;
    private final PublishersMapper mapper;

    public Publisher create(Publisher p) {
        return repo.save(p);
    }

    public Iterable<PublisherView> findAll() {
        return () -> StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(mapper::toDto).iterator();
    }

    public PublisherView create(NewPublisher newpublisher) {
        var pub = mapper.toEntity(newpublisher);
        pub = repo.save(pub);

        return mapper.toDto(pub);
    }
}
