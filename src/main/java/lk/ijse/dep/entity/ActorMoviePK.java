package lk.ijse.dep.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
public class ActorMoviePK implements Serializable {
    @Column(name = "actor_Id")
   private int actorId;
    @Column(name = "movie_Id")
   private int movieId;

    public ActorMoviePK(int actorId, int movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    public ActorMoviePK() {
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
