package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReservationController {

    public JFXButton btnsave;
    public TextField txtUnpaidSerach;
    public TextField txtPaidSearch;
    public TableColumn ColUnpaidDate;
    public TableColumn ColUnpaidStudentName;
    public TableColumn ColUnpaidRoomType;
    public TableColumn ColUnpaidStudentID;
    public TableColumn ColUnpaidReservationID;
    public TableView tblUnpaidStudents;
    public TableColumn ColPaidStatus;
    public TableColumn ColPaidDate;
    public TableColumn ColPaidRoomType;
    public TableColumn ColPaidStudentID;
    public TableColumn ColPaidReservationID;
    public TableView tblPaidStudents;
    public JFXTextField txtStatus;
    public CheckBox cbxStatus;
    public JFXComboBox cmdRoomTypeID;
    public JFXComboBox cmdStudentID;
    public JFXTextField txtName;
    public JFXTextField txtReservationID;
    public JFXButton btnAddNewReservation;

    public void btnNewResevationOnAction(ActionEvent actionEvent) {
    }

    public void cmdOnActionStudent(ActionEvent actionEvent) {
    }

    public void cmdRoomOnAction(ActionEvent actionEvent) {
    }

    public void cbxStatusOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
