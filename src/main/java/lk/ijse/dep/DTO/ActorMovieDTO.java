package lk.ijse.dep.DTO;

public class ActorMovieDTO {


    private int movieId;
    private int actorId;
    private String role;

    public ActorMovieDTO() {
    }

    public ActorMovieDTO( int movieId, int actorId, String role) {

        this.movieId = movieId;
        this.actorId = actorId;
        this.role = role;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ActorMovieDTO{" +
                "movieId=" + movieId +
                ", actorId=" + actorId +
                ", role='" + role + '\'' +
                '}';
    }


}
