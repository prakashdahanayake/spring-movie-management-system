package lk.ijse.dep.DTO;

public class MovieDTO {

    private int movieId;
    private String movieName;

    public MovieDTO(int movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public MovieDTO() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
