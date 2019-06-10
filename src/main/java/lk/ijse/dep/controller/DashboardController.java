package lk.ijse.dep.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController  implements Initializable {

    @FXML
    private ImageView imgManageMovie;

    @FXML
    private ImageView imgManageActors;

    @FXML
    void imgManageActors_OnMouseClicked(MouseEvent event) throws IOException {

        Parent manageActor = FXMLLoader.load(this.getClass().getResource("/fxml/Manageactors.fxml"));
        Scene firstScene = new Scene(manageActor);

        Stage mainStage = (Stage) imgManageMovie.getScene().getWindow();
        mainStage.setScene(firstScene);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void imgRegister_OnMouseclicked(MouseEvent event) throws IOException {
        Parent manageActor = FXMLLoader.load(this.getClass().getResource("/fxml/RegisterActors.fxml"));
        Scene firstScene = new Scene(manageActor);

        Stage mainStage = (Stage) imgManageMovie.getScene().getWindow();
        mainStage.setScene(firstScene);
    }

    public void imgManageMovie_OnMouseclicked(MouseEvent event) throws IOException {
        Parent manageActor = FXMLLoader.load(this.getClass().getResource("/fxml/ManageMovies.fxml"));
        Scene firstScene = new Scene(manageActor);

        Stage mainStage = (Stage) imgManageMovie.getScene().getWindow();
        mainStage.setScene(firstScene);
    }
}
