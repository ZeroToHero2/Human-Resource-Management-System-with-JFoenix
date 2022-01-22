package com.example.cmpe313;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;




public class SceneController { //implements Initializable
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final String PASSWORD = "password";
    @FXML
    TextField usernamee;
    @FXML
    PasswordField passwordd;

    public void switchToMainPart(ActionEvent event) throws IOException {
        String username = usernamee.getText();
        String password = passwordd.getText();

        if (username.equals("Admin") && password.equals( PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (username.equals("Employee") && password.equals(PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (username.equals("Department Manager") && password.equals(PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Departmant.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (username.equals("Education Center") && password.equals(PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Education.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (username.equals("Inventory Manager") && password.equals(PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (username.equals("Acounting Departmant") && password.equals(PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Acounting.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (username.equals("Human Resources") && password.equals(PASSWORD)) {
            root = FXMLLoader.load(getClass().getResource("Human.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Stage window = new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Warning!");
            window.setMinWidth(250);
            Label text = new Label();
            text.setText("Username or password is wrong. Please try again!");
            text.setAlignment(Pos.CENTER);
            VBox box = new VBox();
            box.getChildren().add(text);
            box.setAlignment(Pos.CENTER);

            Scene scene = new Scene(box,400,100);
            window.setScene(scene);
            window.show();
        }

    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }



}

