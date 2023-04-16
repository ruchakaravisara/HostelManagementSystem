package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;

public class LoggingController {
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnSignIn;
    public AnchorPane Loging;

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.DASHBOARD,Loging);
    }

    public void btnUserSignUpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.USERSIGNUP,Loging);
    }
}
