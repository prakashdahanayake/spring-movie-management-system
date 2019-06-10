package lk.ijse.dep.Dao;

import lk.ijse.dep.entity.Actors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDAO extends JpaRepository<Actors,Integer> {

    //Actors getTopActorByOrderByIdDesc()throws Exception;
}
