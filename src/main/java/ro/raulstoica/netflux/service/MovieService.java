package ro.raulstoica.netflux.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.raulstoica.netflux.domain.Movie;
import ro.raulstoica.netflux.domain.MovieEvent;

public interface MovieService {
    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();

    Flux<MovieEvent> streamMovieEvents(String id);
}
