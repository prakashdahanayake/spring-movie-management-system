package lk.ijse.dep.buisness.custom;

import lk.ijse.dep.DTO.ActorDTO;
import lk.ijse.dep.buisness.SuperBO;

import java.util.List;

public interface ActorBO extends SuperBO {

public List<ActorDTO> getAllActors() throws Exception  ;

    public void saveActor(ActorDTO dto)  throws Exception;

    public void updateActor(ActorDTO dto)throws Exception;

    public void removeActor(Integer actorId)throws Exception;

    public ActorDTO getActorById(Integer actorId)throws Exception;

}
