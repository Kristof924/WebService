package com.example.RateMovie.rm.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private String story;
    private String characters;
    private String actors;
    private String visual;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStory() {
        return "Story: " + story + "%";
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getCharacters() {
        return "Characters: " + characters + "%";
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getActors() {
        return "Actors: " + actors + "%";
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getVisual() {
        return "Visual Effects: " + visual + "%";
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
