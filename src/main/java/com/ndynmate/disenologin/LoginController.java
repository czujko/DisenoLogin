package com.ndynmate.disenologin;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class LoginController {

    @FXML
    private TextField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUser;
    @FXML
    private CheckBox checkRemember;
    @FXML
    private Label iblForgottenPass;

    public void initialize() {
        ConexionDB cn = new ConexionDB();
        cn.crearTabla();
        cn.insertarRegistro();
    }

    public void onClickLogin(ActionEvent actionEvent) {
        ConexionDB cn = new ConexionDB();
        if (cn.comprobarUsuario(txtUser.getText(), txtPass.getText())) {
            TilePane tp = new TilePane();
            Alert alert = new Alert(
                    Alert.AlertType.INFORMATION,
                    "Bienvenido a nDynMATE dev",
                    ButtonType.OK);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(
                    Alert.AlertType.ERROR,
                    "Usuario o contraseña incorrectos",
                    ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void onClickForgottenPass(MouseEvent mouseEvent) {
        // TODO : Implementar enviar correo con contraseña
    }
}