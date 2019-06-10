package lk.ijse.dep.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actors implements Serializable {
    @Id
    private int actorId;

    private String actorNAme;
    private String age;
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
    @OneToMany(mappedBy = "actors")
  private List<ActorMovie> actorMovies = new ArrayList<>();


    public Actors(int actorId, String actorNAme, String age) {
        this.actorId = actorId;
        this.actorNAme = actorNAme;
        this.age = age;
    }

    public Actors() {
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorNAme() {
        return actorNAme;
    }

    public void setActorNAme(String actorNAme) {
        this.actorNAme = actorNAme;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "actorId=" + actorId +
                ", actorNAme='" + actorNAme + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public List<ActorMovie> getActorMovies() {
        return actorMovies;
    }

    public void setActorMovies(List<ActorMovie> actorMovies) {
        this.actorMovies = actorMovies;
    }
}
