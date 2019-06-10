package lk.ijse.dep.controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.DTO.MovieDTO;
import lk.ijse.dep.UtilTM.MovieTM;
import lk.ijse.dep.buisness.custom.MovieBO;
import lk.ijse.dep.main.Appinitializer;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageMovieController implements Initializable {


    public TextField txtMovieId;
    public TextField txtMovieName;
    public JFXButton btnsave;
    public JFXButton btnDelete;

    public ImageView btnHome;
    public JFXButton btnNewMovie;
    public TableView<MovieTM> tblMovie;
    private MovieBO movieBO = Appinitializer.ctx.getBean(MovieBO.class);
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblMovie.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMovie.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));

        txtMovieId.setDisable(true);
        txtMovieName.setDisable(true);
        btnsave.setDisable(true);
        btnDelete.setDisable(true);

        try {
            List<MovieDTO> allMovies = movieBO.getAllMovies();
            for (MovieDTO movie : allMovies) {
                tblMovie.getItems().add(new MovieTM(movie.getMovieId(), movie.getMovieName()));
            }
        } catch (Exception e) {

        }

        tblMovie.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MovieTM>() {
            @Override
            public void changed(ObservableValue<? extends MovieTM> observable, MovieTM oldValue, MovieTM selectedMovie) {

                if (selectedMovie == null) {
                    return;
                }

                txtMovieId.setText(String.valueOf(selectedMovie.getMovieId()));
                txtMovieName.setText(selectedMovie.getMovieName());

                txtMovieId.setEditable(false);

                btnsave.setDisable(false);
                btnDelete.setDisable(false);
                txtMovieName.setDisable(false);
            }
        });
        
    }

    public void btnsave_OnAction(ActionEvent actionEvent) {

        if (txtMovieId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Movie ID is empty", ButtonType.OK).showAndWait();
            txtMovieId.requestFocus();
            return;
        } else if (txtMovieName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Movie Name is empty", ButtonType.OK).showAndWait();
            txtMovieName.requestFocus();
            return;
        }

        ///////////////////////////////////////////////////////////////////////
        if (tblMovie.getSelectionModel().isEmpty()) {

            MovieDTO movieDTO = new MovieDTO(Integer.parseInt(txtMovieId.getText()), txtMovieName.getText());
            try {
                movieBO.saveMovie(movieDTO);
                new Alert(Alert.AlertType.INFORMATION, "Movie has been saved successfully", ButtonType.OK).showAndWait();

                MovieTM movieTM = new MovieTM(Integer.parseInt(txtMovieName.getText()), txtMovieName.getText());
                tblMovie.getItems().add(movieTM);
                tblMovie.scrollTo(movieTM);

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the movie, try again", ButtonType.OK).showAndWait();

            }

        } else {
            // Update
            try {
                movieBO.updateMovie(new MovieDTO(Integer.parseInt(txtMovieId.getText()), txtMovieName.getText()));
                new Alert(Alert.AlertType.INFORMATION, "Movie has been updated successfully").show();

                MovieTM selectedMovie = tblMovie.getSelectionModel().getSelectedItem();
                selectedMovie.setMovieName(txtMovieName.getText());
//                tblMovie.refresh();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the movie, try again").show();

            }
        }
        reset();






    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {


        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this movie?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            int selectedRow = tblMovie.getSelectionModel().getSelectedIndex();

            try {
                movieBO.removeMovie(Integer.parseInt(txtMovieId.getText()));
                tblMovie.getItems().remove(tblMovie.getSelectionModel().getSelectedItem());
                reset();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the movie, try again").show();

            }
        }
    }
    private void reset() {
        txtMovieId.clear();
        txtMovieName.clear();
        txtMovieId.requestFocus();
        btnsave.setDisable(false);
        btnDelete.setDisable(true);
        tblMovie.getSelectionModel().clearSelection();
    }

    public void btnHome_Onclicked(MouseEvent event) throws IOException {
        Parent manageActor = FXMLLoader.load(this.getClass().getResource("/fxml/Dashboard.fxml"));
        Scene firstScene = new Scene(manageActor);

        Stage mainStage = (Stage) btnDelete.getScene().getWindow();
        mainStage.setScene(firstScene);
    }

    public void btnNewMovie_OnAction(ActionEvent actionEvent) {

        txtMovieId.requestFocus();
        btnsave.setDisable(false);
        txtMovieName.setDisable(false);
        txtMovieName.setDisable(false);
    }
}
