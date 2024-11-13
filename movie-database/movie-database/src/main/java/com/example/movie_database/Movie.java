package com.example.movie_database;

import java.time.LocalDate;

public class Movie {
    private String title;
    private LocalDate releaseDate;
    private String overview;
    private Double voteAverage;

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        if (releaseDate != null && !releaseDate.isEmpty()) {
            this.releaseDate = LocalDate.parse(releaseDate);
        }
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
