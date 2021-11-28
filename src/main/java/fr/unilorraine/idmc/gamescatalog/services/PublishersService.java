package fr.unilorraine.idmc.gamescatalog.services;

import fr.unilorraine.idmc.gamescatalog.dto.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.dto.PublisherView;
import fr.unilorraine.idmc.gamescatalog.mappers.PublisherMapper;
import fr.unilorraine.idmc.gamescatalog.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PublishersService {

    private final PublisherRepository repo;
    private final PublisherMapper mapper;

    public PublisherView create(NewPublisher p) {
        var pp = mapper.toEntity(p);
        pp = repo.save(pp);
        return mapper.toDto(pp);
    }


    public Iterable<PublisherView> findAll() {
        var result = new ArrayList<PublisherView>();
        repo.findAll().forEach(pub -> result.add(mapper.toDto(pub)) );
        return result;
    }
}
