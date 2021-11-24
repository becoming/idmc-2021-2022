package featurebased.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
