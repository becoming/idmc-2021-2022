package fr.unilorraine.idmc.gamescatalog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;
    private String name;
    private double price;
    private int rating;
    private String category;
    private Instant releaseDate;
    private long publisherId;

}
