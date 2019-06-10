package lk.ijse.dep.UtilTM;

public class MovieTM {
    private int movieId;
    private String movieName;

    public MovieTM(int movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public MovieTM() {
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
