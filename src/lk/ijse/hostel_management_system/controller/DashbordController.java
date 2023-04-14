package lk.ijse.hostel_management_system.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;

public class DashbordController {
    public AnchorPane dashboard;
    public AnchorPane mainMenuID;
    public AnchorPane dash;

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.STUDENT,dash);
    }

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.ROOM,dash);
    }

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.RESERVATION,dashboard);
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.USERS,dash);
    }

    public void btnexistOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN,dashboard);
    }
}
