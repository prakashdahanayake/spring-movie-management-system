package lk.ijse.dep.buisness.custom.impls;

import lk.ijse.dep.DTO.ActorMovieDTO;
import lk.ijse.dep.Dao.ActorMovieDAO;
import lk.ijse.dep.buisness.custom.ActorMovieBO;
import lk.ijse.dep.entity.ActorMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ActorMovieBOImpls implements ActorMovieBO {
@Autowired
private ActorMovieDAO actorMovieDAO;

    @Override
    public void saveActorMovie(ActorMovieDTO dto) throws Exception {
        actorMovieDAO.save(new ActorMovie(dto.getActorId(),dto.getMovieId(),dto.getRole()));
    }
}
