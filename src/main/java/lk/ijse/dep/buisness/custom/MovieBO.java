package lk.ijse.dep.buisness.custom;

import lk.ijse.dep.DTO.ActorDTO;
import lk.ijse.dep.DTO.MovieDTO;
import lk.ijse.dep.buisness.SuperBO;

import java.util.List;

public interface MovieBO extends SuperBO
{
    public List<MovieDTO> getAllMovies() throws Exception  ;

    public void saveMovie(MovieDTO dto)  throws Exception;

    public void updateMovie(MovieDTO dto)throws Exception;

    public void removeMovie(Integer movieId)throws Exception;

    public MovieDTO getMovieById(Integer movieId)throws Exception;
}
