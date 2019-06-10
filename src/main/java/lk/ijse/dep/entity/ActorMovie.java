package lk.ijse.dep.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "actor_movie")
public class ActorMovie {

@EmbeddedId
private ActorMoviePK actorMoviePK;
@ManyToOne
@JoinColumn(name = "actor_Id",referencedColumnName = "actorId",insertable = false, updatable = false)
private Actors actors;
@ManyToOne
@JoinColumn(name = "movie_id",referencedColumnName = "movieId",insertable = false,updatable = false)
private Movie movie;
private String role;



    public ActorMovie() {
    }
    public ActorMovie(ActorMoviePK actorMoviePK, String role) {
        this.actorMoviePK = actorMoviePK;
        this.role = role;
    }

    public ActorMovie(int actorId, int movieId, String role) {
        this.actorMoviePK = new ActorMoviePK(actorId, movieId);
        this.role = role;
    }


    public ActorMoviePK getActorMoviePK() {
        return actorMoviePK;
    }

    public void setActorMoviePK(ActorMoviePK actorMoviePK) {
        this.actorMoviePK = actorMoviePK;
    }

    public Actors getActors() {
        return actors;
    }

    public void setActors(Actors actors) {
        this.actors = actors;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
