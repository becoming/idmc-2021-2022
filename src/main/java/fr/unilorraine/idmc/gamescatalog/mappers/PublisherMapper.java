package fr.unilorraine.idmc.gamescatalog.mappers;

import fr.unilorraine.idmc.gamescatalog.dto.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.dto.PublisherView;
import fr.unilorraine.idmc.gamescatalog.entities.Publisher;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    default List<PublisherView> toDto(Iterable<Publisher> page) {
        var result = new ArrayList<PublisherView>();
        page.forEach(pub -> result.add(toDto(pub)));

        return result;
    }

    PublisherView toDto(Publisher gg);

    Publisher toEntity(NewPublisher dto);
}
