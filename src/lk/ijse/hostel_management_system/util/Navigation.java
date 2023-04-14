package lk.ijse.hostel_management_system.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane DashBoard;
    public static void navigation(Routes routes, AnchorPane DashBoard) throws IOException {
        Navigation.DashBoard = DashBoard;
        Navigation.DashBoard.getChildren().clear();
        Stage window = (Stage) Navigation.DashBoard.getScene().getWindow();

        switch (routes){
            case DASHBOARD:
                window.setTitle("DASHBOARD");
                initUI("Dashbord.fxml");
        }
        switch (routes){
            case ROOM:
                window.setTitle("ROOM");
                initUI("RoomForm.fxml");
        }
        switch (routes){
            case STUDENT:
                window.setTitle("STUDENT");
                initUI("StudentForm.fxml");
        }
        switch (routes) {
            case RESERVATION:
                window.setTitle("RESERVATION");
                initUI("Reservation.fxml");
                break;
        }
        switch (routes) {
            case LOGIN:
                window.setTitle("LOGIN");
                initUI("Logging.fxml");
                break;
        }
        switch (routes) {
            case USERS:
                window.setTitle("USERS");
                initUI("User.fxml");
                break;
        }
        switch (routes) {
            case USERSIGNUP:
                window.setTitle("USERSIGNUP");
                initUI("UserSignUp.fxml");
                break;
        }

    }
    private static void initUI(String location) throws IOException {
        Navigation.DashBoard.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hostel_management_system/view" + location)));
    }
}
