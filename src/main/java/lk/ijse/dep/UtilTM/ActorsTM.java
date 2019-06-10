package lk.ijse.dep.UtilTM;

public class ActorsTM {

    private int actorId;
    private String actorNAme;
    private String age;

    public ActorsTM(int actorId, String actorNAme, String age) {
        this.actorId = actorId;
        this.actorNAme = actorNAme;
        this.age = age;
    }

    public ActorsTM() {
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
