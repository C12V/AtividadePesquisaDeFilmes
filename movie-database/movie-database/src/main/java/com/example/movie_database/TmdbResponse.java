package com.example.movie_database;

import java.util.List;

public class TmdbResponse {
    private List<Movie> results;  // Lista de filmes encontrados

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
