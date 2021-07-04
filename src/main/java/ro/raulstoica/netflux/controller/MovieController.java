package ro.raulstoica.netflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.raulstoica.netflux.domain.Movie;
import ro.raulstoica.netflux.domain.MovieEvent;
import ro.raulstoica.netflux.service.MovieService;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}")
    Mono<Movie> getMovie(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    Flux<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}/events", produces = TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
        return movieService.streamMovieEvents(id);
    }
}
