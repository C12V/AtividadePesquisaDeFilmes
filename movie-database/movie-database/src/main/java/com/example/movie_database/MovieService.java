package com.example.movie_database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Movie searchMovie(String movieName) {
        String url = apiUrl + "?query=" + movieName + "&api_key=" + apiKey + "&language=pt-BR";  // Adicionando parâmetro de idioma

        try {
            TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

            if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
                return response.getResults().get(0);  // Retorna o primeiro resultado
            }
        } catch (HttpClientErrorException e) {
            // Caso ocorra algum erro na requisição, você pode logar ou lançar uma exceção personalizada
            System.err.println("Erro ao buscar o filme: " + e.getMessage());
        } catch (Exception e) {
            // Trata erros genéricos, se houver
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        return null;  // Retorna null caso não encontre ou ocorra erro
    }
}
