package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dto.UserDTO;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;
import java.util.List;

public class LoggingController {
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnSignIn;
    public AnchorPane Loging;

    UserBO usersBO= (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Users);

    public void btnSignInOnAction(ActionEvent actionEvent) throws Exception {
       usersBO.loadAll();
       String userName =txtUserName.getText();
       String password = txtPassword.getText();
        List<UserDTO> userDTOS =usersBO.loadAll();

        for (UserDTO userDTO :userDTOS){
            try {
                if (userDTO.getUserName().equals(userName) &&  userDTO.getPassword().equals(password)){
                    Navigation.navigation(Routes.DASHBOARD,Loging);
                }
                else {
                    txtUserName.setText("Invalid Password !");
                    txtPassword.setText("Invalid UserName !");

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void btnUserSignUpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.USERSIGNUP,Loging);
    }
}
