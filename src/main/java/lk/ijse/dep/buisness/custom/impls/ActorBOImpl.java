package lk.ijse.dep.buisness.custom.impls;

import lk.ijse.dep.DTO.ActorDTO;
import lk.ijse.dep.Dao.ActorDAO;
import lk.ijse.dep.buisness.custom.ActorBO;
import lk.ijse.dep.entity.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Component
@Transactional
public  class ActorBOImpl implements ActorBO {


    @Autowired
    private ActorDAO actorDAO;


    public List<ActorDTO> getAllActors() throws Exception {
        List<ActorDTO> collect = actorDAO.findAll().stream().map(actor -> new ActorDTO(actor.getActorId(), actor.getActorNAme(), actor.getAge())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void saveActor(ActorDTO dto) throws Exception {
         actorDAO.save(new Actors(dto.getActorId(),dto.getActorNAme(),dto.getAge()));


    }

    @Override
    public void updateActor(ActorDTO dto) throws Exception {
        actorDAO.save(new Actors(dto.getActorId(),dto.getActorNAme(),dto.getAge()));
    }

    @Override
    public void removeActor(Integer actorId) throws Exception {
        actorDAO.deleteById(actorId);

    }

    @Override
    public ActorDTO getActorById(Integer actorId) throws Exception {
        Actors actor = actorDAO.getOne(actorId);
        ActorDTO actorDTO = new ActorDTO(actor.getActorId(), actor.getActorNAme(), actor.getAge());
        return actorDTO;

    }

}
