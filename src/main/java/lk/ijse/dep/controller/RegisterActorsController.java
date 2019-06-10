package lk.ijse.dep.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.dep.DTO.ActorDTO;
import lk.ijse.dep.DTO.ActorMovieDTO;
import lk.ijse.dep.DTO.MovieDTO;
import lk.ijse.dep.buisness.custom.ActorBO;
import lk.ijse.dep.buisness.custom.ActorMovieBO;
import lk.ijse.dep.buisness.custom.MovieBO;
import lk.ijse.dep.main.Appinitializer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class RegisterActorsController implements Initializable {


    public TextField txtMoviename;
    public TextField txtRole;
    public TextField txtactorName;
    public JFXComboBox cmbMovieId;
    public JFXComboBox cmbActorId;
    public Button btnRegister;

    private MovieBO movieBO = Appinitializer.ctx.getBean(MovieBO.class);
    private ActorBO actorBO = Appinitializer.ctx.getBean(ActorBO.class);
    private ActorMovieBO actorMovieBO = Appinitializer.ctx.getBean(ActorMovieBO.class);
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // Loading all Movie Ids
        try {
            List<MovieDTO> allMovies = movieBO.getAllMovies();
            for (MovieDTO movie : allMovies) {
                cmbMovieId.getItems().add(movie.getMovieId());
            }
        } catch (Exception e) {

        }

        cmbMovieId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object movieId) {

                try {
                    if (movieId == null)
                        return;

                    MovieDTO movie = movieBO.getMovieById((Integer) movieId);
                    txtMoviename.setText(movie.getMovieName());

                } catch (Exception e) {

                }

            }
        });

        // Loading all Actor Ids
        try {
            List<ActorDTO> allActors = actorBO.getAllActors();
            for (ActorDTO actor : allActors) {
                cmbActorId.getItems().add(actor.getActorId());
            }
        } catch (Exception e) {

        }

        cmbActorId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object actorId) {
                try {
                    if (actorId == null)
                        return;

                    ActorDTO actor = actorBO.getActorById((Integer) actorId);
                    txtactorName.setText(actor.getActorNAme());
                } catch (Exception e) {

                }
            }
        });
        
    }

    public void cmbMovieId_OnAction(ActionEvent actionEvent) {
    }

    public void cmbActorId_Onaction(ActionEvent actionEvent) {
    }

    public void btnRegister_OnAction(ActionEvent actionEvent) {


        if (cmbMovieId.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Movie ID is empty", ButtonType.OK).showAndWait();
            cmbMovieId.requestFocus();
            return;
        } else if (cmbMovieId == null) {
            new Alert(Alert.AlertType.ERROR, "Actor ID is empty", ButtonType.OK).showAndWait();
            cmbMovieId.requestFocus();
            return;
        }

        ActorMovieDTO actorMovieDTO = new ActorMovieDTO(Integer.parseInt(cmbMovieId.getValue().toString()), Integer.parseInt(cmbActorId.getValue().toString()), txtRole.getText());
        try {
            actorMovieBO.saveActorMovie(actorMovieDTO);

            new Alert(Alert.AlertType.INFORMATION, "Actor and Movie has been saved successfully", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
