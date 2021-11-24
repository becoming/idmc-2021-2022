package featurebased.game;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

//https://www.baeldung.com/mapstruct#1-modify-the-mapper
@Mapper(componentModel = "spring")
public interface GamesMapper {

    default List<GameView> toDto(Iterable<Game> games) {
        var result = new ArrayList<GameView>();
        games.forEach(game -> result.add(toDto(game)));

        return result;
    }

//    https://www.baeldung.com/mapstruct-custom-mapper#custom-mapper-annotation
    @Mapping(source = "publisher.id", target = "publisherId")
    @Mapping(source = "publisher.name", target = "publisherName")
    GameView toDto(Game gg);

//    https://www.baeldung.com/mapstruct-ignore-unmapped-properties#ignore-specific-fields
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Game toEntity(NewGame dto);
}
