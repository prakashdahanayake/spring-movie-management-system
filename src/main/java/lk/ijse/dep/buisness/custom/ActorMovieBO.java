package lk.ijse.dep.buisness.custom;

import lk.ijse.dep.DTO.ActorMovieDTO;
import lk.ijse.dep.buisness.SuperBO;

public interface ActorMovieBO extends SuperBO {

   public void saveActorMovie(ActorMovieDTO dto) throws Exception;


}
