package fr.unilorraine.idmc.gamescatalog.mappers;

import fr.unilorraine.idmc.gamescatalog.dto.PublisherView;
import fr.unilorraine.idmc.gamescatalog.dto.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.entities.Publisher;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    default List<PublisherView> toDto(Page<Publisher> page) {
        return page
                .map(this::toDto)
                .getContent();
    }

    //    https://www.baeldung.com/mapstruct-custom-mapper#custom-mapper-annotation
    PublisherView toDto(Publisher pp);

    //    https://www.baeldung.com/mapstruct-ignore-unmapped-properties#ignore-specific-fields
    Publisher toEntity(NewPublisher dto);
}
