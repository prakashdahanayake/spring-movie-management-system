package lk.ijse.dep.Dao;

import lk.ijse.dep.entity.ActorMovie;
import lk.ijse.dep.entity.ActorMoviePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieDAO extends JpaRepository<ActorMovie, ActorMoviePK> {

}
