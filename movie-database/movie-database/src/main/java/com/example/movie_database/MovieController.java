package com.example.movie_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String index() {
        return "movie";  
    }

    @PostMapping("/search")
    public String searchMovie(@RequestParam("movieName") String movieName, Model model) {
        Movie movie = movieService.searchMovie(movieName);
        model.addAttribute("movie", movie);
        return "movie";
    }
}
