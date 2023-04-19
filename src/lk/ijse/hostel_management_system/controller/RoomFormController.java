package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.RoomBO;
import lk.ijse.hostel_management_system.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class RoomFormController {
    public JFXButton btnAddRoom;
    public Label lblId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TableView <RoomDTO> tblRoom;
    public TableColumn<RoomDTO, String> colRoomTypeId;
    public TableColumn<RoomDTO, String> colType;
    public TableColumn<RoomDTO, String> colKeyMoey;
    public TableColumn<RoomDTO, Integer> colQty;
    public JFXTextField txtRoomId;

    RoomBO roomBO =(RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Rooms);;
    public static ObservableList obList = FXCollections.observableArrayList();

    public  void initialize() throws Exception {
        loadAllRoom();
        getData();
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoey.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void loadAllRoom() throws Exception {
        tblRoom.getItems().clear();

        List<RoomDTO> studentDTOS = roomBO.loadAllRoom();
        ObservableList<RoomDTO> observableList= FXCollections.observableList(studentDTOS);
        tblRoom.setItems(observableList);

    }
    void clear(){
        txtRoomId.clear();
        txtType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
    }

    public void btnaddOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSave =roomBO.saveRoom(new RoomDTO(
                txtRoomId.getText(),
                txtType.getText(),
                txtKeyMoney.getText(),
                Integer.parseInt(txtQty.getText()
        )));
        if (isSave){
            new Alert(Alert.AlertType.CONFIRMATION, "Room Save Successfully!").show();
            clear();

            tblRoom.getItems().clear();
            loadAllRoom();
        }else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        RoomDTO roomDTO =new RoomDTO(
               txtRoomId.getText(),
                txtType.getText(),
                txtKeyMoney.getText(),
                Integer.parseInt(txtQty.getText())
        );
     //   System.out.println(roomDTO);
        boolean isUpdate = roomBO.updateRoom(roomDTO);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION, "Room Update Successfully!").show();
            clear();

            tblRoom.getItems().clear();
            loadAllRoom();
        }else{
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        RoomDTO roomDTO =new RoomDTO(
                txtRoomId.getText(),
                txtType.getText(),
                txtKeyMoney.getText(),
                Integer.parseInt(txtQty.getText())
        );
        boolean isDeleted = roomBO.deleteRoom(roomDTO);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION, "Room Delete Successfully!").show();

            clear();
            tblRoom.getItems().clear();
            loadAllRoom();
        }else{

            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }
    void getData(){
        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue != null) {
                txtRoomId.setText(newValue.getId());
                txtType.setText(newValue.getType());
                txtQty.setText(String.valueOf(newValue.getQty()));
                txtKeyMoney.setText(newValue.getKeyMoney());
            }
        });
    }
}
