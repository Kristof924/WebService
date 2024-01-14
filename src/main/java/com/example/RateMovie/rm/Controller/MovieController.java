package com.example.RateMovie.rm.Controller;

import com.example.RateMovie.rm.Entity.CommentEntity;
import com.example.RateMovie.rm.Entity.MovieEntity;
import com.example.RateMovie.rm.Service.CommentService;
import com.example.RateMovie.rm.Service.MovieService;
import com.example.RateMovie.rm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    @Autowired
    private final MovieService movieService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final CommentService commentService;
    public MovieController(MovieService movieService, UserService userService, CommentService commentService) {
        this.movieService = movieService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping("/movie/{id}")
    public String index(@PathVariable Long id, Model model){
        model.addAttribute("isAdmin", userService.Admin());
        model.addAttribute("isLogged", !userService.Logged());
        model.addAttribute("logout", userService.Logged());
        model.addAttribute("movies",movieService.getOneMovie(id));
        model.addAttribute("MovieTitle", new MovieEntity());
        model.addAttribute("Comment", new CommentEntity());
        model.addAttribute("isLogg", userService.Logged());
        model.addAttribute("ShowComments", commentService.getMovieComment(movieService.getOneMovie(id).getId()));
        return "index";
    }
    @PostMapping ("/comment")
    public String Comment(@ModelAttribute CommentEntity comment){
        System.out.println("SAD");
        commentService.saveComment(comment);
        System.out.println("ASDADSADADS" + comment);

        return "redirect:/";
    }
    @RequestMapping("/")
    public String HomePage(Model model){
        model.addAttribute("isAdmin", userService.Admin());
        model.addAttribute("isLogged", !userService.Logged());
        model.addAttribute("logout", userService.Logged());
        model.addAttribute("movies", movieService.getAllMovie());
        model.addAttribute("MovieTitle", new MovieEntity());
        return "HomePage";
    }
    @PostMapping("/search")
    public String Search(@ModelAttribute MovieEntity movie){
        Long id = movieService.findIdByTitle(movie.getTitle());

        return "redirect:/movie/" + id.intValue();
    }
    @PostMapping("/movie/search")
    public String SearchIndex(@ModelAttribute MovieEntity movie){
        Long id = movieService.findIdByTitle(movie.getTitle());

        return "redirect:/movie/" + id.intValue();
    }

}
