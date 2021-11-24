package fr.unilorraine.idmc.gamescatalog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class GameView {

    private String name;
    private Long price;
    private int rating;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Instant releaseDate;

    private Long publisherId;
    private String publisherName;

}
