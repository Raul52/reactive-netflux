package ro.raulstoica.netflux.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ro.raulstoica.netflux.domain.Movie;
import ro.raulstoica.netflux.repository.MovieRepository;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;

    //initialize the mongo database with
    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Gladiator", "Dark Knight", "The Last Samurai")
                                .map(Movie::new)
                                .flatMap(movieRepository::save)
                ).subscribe(null, null, () -> {
                    System.out.println("Database has been initialized. The following movies have been persisted:");
                    movieRepository.findAll().subscribe(System.out::println);
        });
    }
}
