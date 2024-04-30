package com.netflixgpt.controller;

import com.netflixgpt.services.ImdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("imdb")
@RequiredArgsConstructor
public class IMDBApiController {

    private final ImdbService imdbService;

    @GetMapping("/nowPlaying")
    public ResponseEntity<?> getNowPlaying() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?page=1";
        return imdbService.nowPlayingTMDBApi(url);
    }

    @GetMapping("/movie_trailer/{movieId}")
    public ResponseEntity<?> getNowPlaying(@PathVariable String movieId) {
        String url =  "https://api.themoviedb.org/3/movie/" + movieId + "/videos?language=en-US";
        return imdbService.nowPlayingTMDBApi(url);
    }

    @GetMapping("/popular_movies")
    public ResponseEntity<?> getPopularMovie() {
        String url =  "https://api.themoviedb.org/3/movie/popular?page=1";
        return imdbService.nowPlayingTMDBApi(url);
    }


    @GetMapping("/top_rated_movies")
    public ResponseEntity<?> getTopRatedMovie() {
        String url =  "https://api.themoviedb.org/3/movie/top_rated?page=1";
        return imdbService.nowPlayingTMDBApi(url);
    }


    @GetMapping("/up_coming_movies")
    public ResponseEntity<?> getUpComingMovie() {
        String url =  "https://api.themoviedb.org/3/movie/upcoming?page=1";
        return imdbService.nowPlayingTMDBApi(url);
    }


}
