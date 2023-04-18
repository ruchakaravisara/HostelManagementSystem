package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dto.UserDTO;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;

public class UserSignUpController {
    public TextField txtUserID;
    public TextField txtUserName;
    public TextField txtUserPassword;
    public TextField txtUserEmail;
    public JFXButton btnNewSign;
    public JFXButton btnSignUpID;
    public JFXButton btnSign1;
    public AnchorPane UserSignUp;

    UserBO userBO =(UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Users);

    public void initialize(){
        iniUI();
    }
    public void iniUI(){
        txtUserID.clear();
        txtUserName.clear();
        txtUserPassword.clear();
        txtUserEmail.clear();
        txtUserID.setDisable(true);
        txtUserName.setDisable(true);
        txtUserPassword.setDisable(true);
        txtUserEmail.setDisable(true);
    }
    private String generateNextUserID(){
        try {
          return userBO.generateNextUserID();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Failed Generate ID"+e.getMessage()).show();
            e.printStackTrace();
        }
        return "U00-001";
    }

    public void btnNewSignID(ActionEvent actionEvent) {
        txtUserID.setEditable(false);
        txtUserName.setDisable(false);
        txtUserPassword.setDisable(false);
        txtUserEmail.setDisable(false);
        txtUserID.clear();
        txtUserID.setText(generateNextUserID());
        txtUserName.clear();
        txtUserPassword.clear();
        txtUserEmail.clear();
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) throws Exception {
        String id =txtUserID.getText();
        String userName =txtUserName.getText();
        String password=txtUserPassword.getText();
        String email=txtUserEmail.getText();

        if (btnSignUpID.getText().equalsIgnoreCase("Sign UP")){
            userBO.saveUser(new UserDTO(id,userName,password,email));
            new Alert(Alert.AlertType.INFORMATION,"Account Has Been Created").show();
        }
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
       Navigation.navigation(Routes.LOGIN,UserSignUp);
    }
}
