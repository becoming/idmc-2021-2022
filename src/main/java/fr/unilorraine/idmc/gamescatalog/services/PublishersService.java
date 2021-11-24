package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.dto.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.dto.PublisherView;
import fr.unilorraine.idmc.gamescatalog.mappers.PublisherMapper;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PublishersService {

    private final PublisherRepository repo;
    private final PublisherMapper mapper;

    public PublisherView create(NewPublisher p) {
        var pub = mapper.toEntity(p);
        pub = repo.save(pub);

        return mapper.toDto(pub);
    }

    public List<PublisherView> findAll() {
        return mapper.toDto(repo.findAll());
    }
}
