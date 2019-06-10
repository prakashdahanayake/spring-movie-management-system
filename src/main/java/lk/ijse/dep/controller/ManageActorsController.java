package lk.ijse.dep.controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.DTO.ActorDTO;
import lk.ijse.dep.UtilTM.ActorsTM;
import lk.ijse.dep.buisness.custom.ActorBO;
import lk.ijse.dep.main.Appinitializer;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ManageActorsController implements Initializable {


    public TextField txtactorName;
    public TextField txtActorAge;
    public JFXButton btnSavceactor;
    public JFXButton btnDeleteActor;
    public JFXButton btnNewActor;
    public ImageView btnHomeactor;
    public TableView <ActorsTM>tblManageactors;
    public TextField txtactorId;
    public Label lblMain;

    private ActorBO actorBO = Appinitializer.ctx.getBean(ActorBO.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        tblManageactors.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("actorId"));
        tblManageactors.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("actorNAme"));
        tblManageactors.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("age"));

        btnDeleteActor.setDisable(true);
        btnSavceactor.setDisable(true);

        try {
            List<ActorDTO> actorDTOList = actorBO.getAllActors();
            for (ActorDTO actorDTO:actorDTOList){
                tblManageactors.getItems().add(new ActorsTM(actorDTO.getActorId(), actorDTO.getActorNAme(), actorDTO.getAge()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblManageactors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ActorsTM>() {
            @Override
            public void changed(ObservableValue<? extends ActorsTM> observable, ActorsTM oldValue, ActorsTM selectedActor) {

                if (selectedActor == null) {
                    return;
                }

                txtactorId.setText(String.valueOf(selectedActor.getActorId()));
                txtactorName.setText(selectedActor.getActorNAme());
                txtActorAge.setText(String.valueOf(selectedActor.getAge()));

                txtactorId.setEditable(false);

                btnSavceactor.setDisable(false);
                btnDeleteActor.setDisable(false);
            }
        });
    }


    public void btnHomeactor_Onaction(ActionEvent actionEvent) {


    }

    public void btnDeleteActor_Onaction(ActionEvent actionEvent) {

        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this actor?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            int selectedRow = tblManageactors.getSelectionModel().getSelectedIndex();

            try {
                actorBO.removeActor(Integer.valueOf(txtactorId.getText()));
                tblManageactors.getItems().remove(tblManageactors.getSelectionModel().getSelectedItem());
                reset();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the actor, try again").show();

            }
        }



    }


    public void btnNewActor_Onaction(ActionEvent actionEvent) {

        txtactorId.requestFocus();
        txtactorId.setDisable(false);
        btnSavceactor.setDisable(false);




    }
    private void reset() {
        txtactorId.clear();
        txtactorName.clear();
        txtActorAge.clear();
        txtactorId.requestFocus();
        txtactorId.setEditable(true);
        btnSavceactor.setDisable(false);
        btnDeleteActor.setDisable(true);
        tblManageactors.getSelectionModel().clearSelection();
    }
    public void btnHomeactor_OnAction(MouseEvent event) throws IOException {
        Parent manageActor = FXMLLoader.load(this.getClass().getResource("/fxml/Dashboard.fxml"));
        Scene firstScene = new Scene(manageActor);

        Stage mainStage = (Stage) lblMain.getScene().getWindow();
        mainStage.setScene(firstScene);
    }

    public void btnSavceactor_Onaction(ActionEvent actionEvent) {
        if (txtactorId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Actor ID is empty", ButtonType.OK).showAndWait();
            txtactorId.requestFocus();
            return;
        } else if (txtactorName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Actor Name is empty", ButtonType.OK).showAndWait();
            txtactorName.requestFocus();
            return;
        } else if (txtActorAge.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Actor Age is empty", ButtonType.OK).showAndWait();
            txtActorAge.requestFocus();
            return;
        }




     if (tblManageactors.getSelectionModel().isEmpty()){

           /* ObservableList<ActorTM> items = tblActor.getItems();
            for (ActorTM actorTM : items) {
                if (actorTM.getId().equals(txtActorID.getText())) {
                }
            }*/

        ActorDTO actorDTO = new ActorDTO(Integer.parseInt(txtactorId.getText()), txtactorName.getText(), txtActorAge.getText());
        try {
            actorBO.saveActor(actorDTO);
            new Alert(Alert.AlertType.INFORMATION, "Actor has been saved successfully", ButtonType.OK).showAndWait();

            ActorsTM actorTM = new ActorsTM(Integer.parseInt(txtactorId.getText()), txtactorName.getText(), txtActorAge.getText());
            tblManageactors.getItems().add(actorTM);
            tblManageactors.scrollTo(actorTM);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the actor, try again", ButtonType.OK).showAndWait();

        }


    } else {
        // Update
        try {
            actorBO.updateActor(new ActorDTO(Integer.parseInt(txtactorId.getText()), txtactorName.getText(), txtActorAge.getText()));
            new Alert(Alert.AlertType.INFORMATION, "Actor has been updated successfully").show();

            ActorsTM selectedActor = tblManageactors.getSelectionModel().getSelectedItem();
            selectedActor.setActorNAme(txtactorName.getText());
            selectedActor.setAge((txtActorAge.getText()));
//            tblManageactors.refresh();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to update the actor, try again").show();

        }
        reset();
    }



    }}
