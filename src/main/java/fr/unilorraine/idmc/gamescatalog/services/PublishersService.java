package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.dto.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.dto.PublisherView;
import fr.unilorraine.idmc.gamescatalog.entities.Publisher;
import fr.unilorraine.idmc.gamescatalog.mappers.GamesMapper;
import fr.unilorraine.idmc.gamescatalog.mappers.PublishersMapper;
import fr.unilorraine.idmc.gamescatalog.repositories.GamesRepository;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishersService {

    private final PublisherRepository repo;
    private final PublishersMapper mapper;

    public List<PublisherView> findAll() {
        return mapper.toDto(repo.findAll());
    }

    public PublisherView create(NewPublisher newpublisher){
        var pub = mapper.toEntity(newpublisher);
        pub = repo.save(pub);

        return mapper.toDto(pub);
    }
}
