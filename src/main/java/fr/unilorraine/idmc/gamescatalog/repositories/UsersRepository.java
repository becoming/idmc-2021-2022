package fr.unilorraine.idmc.gamescatalog.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.unilorraine.idmc.gamescatalog.entities.User;

public interface UsersRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
