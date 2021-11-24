package fr.unilorraine.idmc.gamescatalog.publisher;

import fr.unilorraine.idmc.gamescatalog.publisher.data.NewPublisher;
import fr.unilorraine.idmc.gamescatalog.publisher.data.PublisherEntity;
import fr.unilorraine.idmc.gamescatalog.publisher.data.PublisherView;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    default List<PublisherView> toDto(Page<PublisherEntity> page) {
        return page
                .map(this::toDto)
                .getContent();
    }

    //    https://www.baeldung.com/mapstruct-custom-mapper#custom-mapper-annotation
    PublisherView toDto(PublisherEntity pp);

    //    https://www.baeldung.com/mapstruct-ignore-unmapped-properties#ignore-specific-fields
    PublisherEntity toEntity(NewPublisher dto);
}
