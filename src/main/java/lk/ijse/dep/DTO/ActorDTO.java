package lk.ijse.dep.DTO;

public class ActorDTO {

    private int actorId;
    private String actorNAme;
    private String age;


    public ActorDTO(int actorId, String actorNAme, String age) {
        this.actorId = actorId;
        this.actorNAme = actorNAme;
        this.age = age;
    }

    public ActorDTO() {
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
}
