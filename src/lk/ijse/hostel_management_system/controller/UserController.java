package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dto.UserDTO;

import java.util.List;

public class UserController {
    public JFXTextField txtUserID;
    public JFXTextField txtUserName;
    public JFXTextField txtUserPassword;
    public JFXTextField txtUserContact;
    public Button btnsave;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView<UserDTO> tblUsers;
    public TableColumn<UserDTO, String> ColID;
    public TableColumn<UserDTO, String> ColUserName;
    public TableColumn ColUserPassword;
    public TableColumn<UserDTO, String> ColUserContact;
    UserBO usersBO= (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Users);

    public void initialize() throws Exception {
        getData();
        loadAllUser();
        ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        ColUserPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        ColUserContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    private void loadAllUser() throws Exception {
        tblUsers.getItems().clear();
        List<UserDTO> studentDTOS = usersBO.loadAll();
        ObservableList<UserDTO> observableList= FXCollections.observableList(studentDTOS);
        tblUsers.setItems(observableList);
    }

    void clear(){
        txtUserID.clear();
        txtUserName.clear();
        txtUserPassword.clear();
        txtUserContact.clear();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved =usersBO.saveUser(new UserDTO(
                txtUserID.getText(),
                txtUserName.getText(),
                txtUserPassword.getText(),
                txtUserContact.getText()));

                if(isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "User Save Successfully!").show();
            clear();
                    tblUsers.getItems().clear();
                    loadAllUser();
        }else{
                    new Alert(Alert.AlertType.WARNING, "Something happened!").show();

                }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        boolean isUpdated =usersBO.updateUser(new UserDTO(

                txtUserID.getText(),
                txtUserName.getText(),
                txtUserPassword.getText(),
                txtUserContact.getText()));

        if (isUpdated){

            new Alert(Alert.AlertType.CONFIRMATION, "User Update Successfully!").show();

            clear();

            tblUsers.getItems().clear();
            loadAllUser();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();

        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        boolean isDeleted =usersBO.deleteUser(new UserDTO(

                txtUserID.getText(),
                txtUserName.getText(),
                txtUserPassword.getText(),
                txtUserContact.getText()));
        if (isDeleted){

            new Alert(Alert.AlertType.CONFIRMATION, "User Delete Successfully!").show();

            clear();

            tblUsers.getItems().clear();
            loadAllUser();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();

        }
    }
    void getData(){
        tblUsers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue != null) {
                txtUserID.setText(newValue.getId());
                txtUserName.setText(newValue.getUserName());
                txtUserPassword.setText(newValue.getPassword());
                txtUserContact.setText(newValue.getContact());

            }
        });
    }
}
