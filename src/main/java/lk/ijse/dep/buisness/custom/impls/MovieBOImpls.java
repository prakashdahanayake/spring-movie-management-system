package lk.ijse.dep.buisness.custom.impls;

import lk.ijse.dep.DTO.ActorDTO;
import lk.ijse.dep.DTO.MovieDTO;
import lk.ijse.dep.Dao.MovieDAO;
import lk.ijse.dep.buisness.SuperBO;
import lk.ijse.dep.buisness.custom.MovieBO;
import lk.ijse.dep.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Component
@Transactional
public class MovieBOImpls implements MovieBO {

    @Autowired
private MovieDAO movieDAO;

    @Override
    public List<MovieDTO> getAllMovies() throws Exception {

      List<MovieDTO> movieDTOList =  movieDAO.findAll().stream().map(movie -> new MovieDTO(movie.getMovieId(), movie.getMovieName())).collect(Collectors.toList());
        return movieDTOList;
    }

    @Override
    public void saveMovie(MovieDTO dto) throws Exception {
        movieDAO.save(new Movie(dto.getMovieId(), dto.getMovieName()));

    }

    @Override
    public void updateMovie(MovieDTO dto) throws Exception {
       movieDAO.save(new Movie(dto.getMovieId(),dto.getMovieName()));
    }

    @Override
    public void removeMovie(Integer movieId) throws Exception {
        movieDAO.deleteById(movieId);

    }

    @Override
    public MovieDTO getMovieById(Integer movieId) throws Exception {
          Movie movie =movieDAO.getOne(movieId);
          MovieDTO movieDTO = new MovieDTO(movie.getMovieId(),movie.getMovieName());
        return movieDTO;
    }
}
