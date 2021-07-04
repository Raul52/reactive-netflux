package ro.raulstoica.netflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ro.raulstoica.netflux.domain.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
