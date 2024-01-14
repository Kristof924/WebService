package com.example.RateMovie.rm.Controller;

import com.example.RateMovie.rm.Entity.MovieEntity;
import com.example.RateMovie.rm.Entity.UserEntity;
import com.example.RateMovie.rm.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminController {
    @Autowired
    private final MovieService movieService;

    public AdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("filmForm", new MovieEntity());
        return "AdminPage";
    }

    @PostMapping("/saveFilm")
    public String saveFilm(@ModelAttribute MovieEntity movie, @RequestParam("file") MultipartFile file) throws IOException {
        MovieEntity m = new MovieEntity();
        m.setTitle(movie.getTitle());
        m.setDirector(movie.getDirector());
        m.setDescription(movie.getDescription());
        m.setActors("0");
        m.setCharacters("0");
        m.setVisual("0");
        m.setStory("0");
        movieService.saveMovie(m);
        movieService.saveImage(file, m);

        return "redirect:/";
    }

}
