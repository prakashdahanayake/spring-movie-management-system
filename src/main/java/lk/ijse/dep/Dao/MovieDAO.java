package lk.ijse.dep.Dao;

import lk.ijse.dep.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO  extends JpaRepository<Movie,Integer> {
   // Movie getTopMovieByOrderByIdDesc()throws Exception;
}
