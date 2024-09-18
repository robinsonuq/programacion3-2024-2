package com.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.Model.UserModel;

public class LoginController {

    private UserModel userModel;

    public LoginController(){
        this.userModel = new UserModel();
    }

    @FXML
    private Button btnLogin;

    @FXML
    private Label messageLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void bntLoginClicked(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(userModel.isValidUser(username, password)){
            messageLabel.setText("Inicio de Sesión Exitoso!");
        } else {
            messageLabel.setText("Nombre de Usuario o Contraseña Invalidos");
        }
    }
}