package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.ReservationBO;
import lk.ijse.hostel_management_system.dto.ReservationDTO;
import lk.ijse.hostel_management_system.dto.RoomDTO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.projection.StudentDetailsDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationController {

    public JFXButton btnsave;
    public TextField txtUnpaidSerach;
    public TextField txtPaidSearch;
    public TableColumn<StudentDetailsDTO, Date> ColUnpaidDate;
    public TableColumn <StudentDetailsDTO, String>ColUnpaidStudentName;
    public TableColumn <StudentDetailsDTO, String> ColUnpaidRoomType;
    public TableColumn<StudentDetailsDTO, String>  ColUnpaidStudentID;
    public TableColumn <StudentDetailsDTO, String>ColUnpaidReservationID;
    public TableView <StudentDetailsDTO>tblUnpaidStudents;
    public TableColumn<ReservationDTO, String> ColPaidStatus;
    public TableColumn<ReservationDTO, java.sql.Date> ColPaidDate;
    public TableColumn <ReservationDTO, String>ColPaidRoomType;
    public TableColumn<ReservationDTO, String> ColPaidStudentID;
    public TableColumn <ReservationDTO, String>ColPaidReservationID;
    public TableView<ReservationDTO> tblPaidStudents;
    public JFXTextField txtStatus;
    public CheckBox cbxStatus;
    public JFXComboBox cmdRoomTypeID;
    public JFXComboBox cmdStudentID;
    public JFXTextField txtName;
    public JFXTextField txtReservationID;
    public JFXButton btnAddNewReservation;
    public JFXTextField txtRoomQTY;

    private StudentDTO studentData;
    private RoomDTO roomData;
    private String id;

    ReservationBO reservationBO =(ReservationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Reservation);

    public void initialize() throws Exception {
        properties();
        loadAllStudent();
        loadAllRooms();
        loadAll();
        setAllProjection();
        setCheckStatus();
        iniUI();
    }
    public void properties(){
        ColPaidReservationID.setCellValueFactory(new PropertyValueFactory<>("resId"));
        ColPaidStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        ColPaidRoomType.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        ColPaidDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        ColPaidStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        ColUnpaidReservationID.setCellValueFactory(new PropertyValueFactory<>("resId"));
        ColUnpaidRoomType.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        ColUnpaidStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        ColUnpaidStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColUnpaidDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        }

        void setCheckStatus(){
            tblUnpaidStudents.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                btnsave.setText(newValue!=null ? "update" : "save");
                btnsave.setDisable(newValue==null);

                if (newValue != null){
                    cbxStatus.setDisable(false);
                    id= newValue.getResId();
                }
            });
        }

        private void loadAllStudent(){
        try {
            ArrayList<StudentDTO> allStudent =(ArrayList<StudentDTO>) reservationBO.getAllStudent();
            for (StudentDTO s :allStudent){
                cmdStudentID.getItems().add(s.getId());
                if (s.getId().equals(cmdStudentID.getValue())){
                    txtName.setText(s.getAddress());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        private void loadAllRooms(){
        try {
            ArrayList<RoomDTO>allRooms= (ArrayList<RoomDTO>) reservationBO.getAllRoom();
            for (RoomDTO r :allRooms){
                cmdRoomTypeID.getItems().add(r.getId());
                if (r.getId().equals(cmdRoomTypeID.getValue())){
                    txtRoomQTY.setText(String.valueOf(r.getQty()));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
        private StudentDTO getStudentDTO() throws Exception {
            String studentId= (String) cmdStudentID.getSelectionModel().getSelectedItem();
            return reservationBO.getStudent(studentId);
        }
    private RoomDTO getRoomDTO() throws Exception {
        String roomId= (String) cmdRoomTypeID.getSelectionModel().getSelectedItem();
        return reservationBO.getRoom(roomId);
    }
    private void loadAll() throws Exception {
        List<ReservationDTO> reservationDTOList=reservationBO.loadAll();
        ObservableList<ReservationDTO> dtoObservableList= FXCollections.observableList(reservationDTOList);

        tblPaidStudents.setItems(dtoObservableList);

    }
    private String generateNewIds(){
        try {
            return reservationBO.generateNextReservationID();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
            e.printStackTrace();
        }
        return "RE-001";
    }
    void iniUI(){
        cmdStudentID.setDisable(true);
        cmdRoomTypeID.setDisable(true);
        btnsave.setDisable(true);
        txtName.setEditable(false);
        txtRoomQTY.setEditable(false);
    }

    public void btnNewResevationOnAction(ActionEvent actionEvent) {
        txtReservationID.setEditable(false);
        txtName.setEditable(false);
        txtRoomQTY.setEditable(false);
        cmdStudentID.setDisable(false);
        cmdRoomTypeID.setDisable(false);
        txtReservationID.setText(generateNewIds());
        btnsave.setText("Save Reservation");
        btnsave.setDisable(false);

    }

    public void cmdOnActionStudent(ActionEvent actionEvent) throws Exception {
        studentData=getStudentDTO();
        txtName.setText(studentData.getName());

    }

    public void cmdRoomOnAction(ActionEvent actionEvent) throws Exception {
        roomData =getRoomDTO();
        txtRoomQTY.setText(String.valueOf(roomData.getQty()));
    }

    public void cbxStatusOnAction(ActionEvent actionEvent) {
        if (btnsave.getText().equals("Update")){
            if (cbxStatus.isSelected()){
                btnsave.setDisable(false);
                String status="paid";
            }else if (!cbxStatus.isSelected())btnsave.setDisable(true);
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        if (btnsave.getText().equals("Save Reservation")){
            boolean isSaved=reserveRoom(getData());
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Room Reserved").show();
                tblPaidStudents.getItems().clear();
                tblUnpaidStudents.refresh();
                loadAll();

            }else {
                new Alert(Alert.AlertType.ERROR, "Error").show();
            }
        }else if(btnsave.getText().equals("update")){
            if (cbxStatus.isSelected()){
                btnsave.setDisable(false);
                String status="paid";

                boolean isUpdated=reservationBO.checkStatusClick(id,status);
                tblUnpaidStudents.refresh();
                if (isUpdated){
                    tblUnpaidStudents.getItems().clear();
                    tblPaidStudents.getItems().clear();

                    new Alert(Alert.AlertType.CONFIRMATION, "Status updated").show();

                    loadAll();
                    setAllProjection();

                    cbxStatus.setDisable(true);
                    btnsave.setDisable(true);
                    tblUnpaidStudents.refresh();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Error").show();
                }
            }
        }

    }
    private void setAllProjection() throws Exception {
        List<StudentDetailsDTO>list=reservationBO.getAllProjection();
        ObservableList<StudentDetailsDTO>studentDetailsDTOS=FXCollections.observableList(list);

        tblUnpaidStudents.refresh();
        tblUnpaidStudents.setItems(studentDetailsDTOS);

    }
    private boolean reserveRoom(ReservationDTO reservationDTO) throws Exception {
        boolean isSaved= Boolean.parseBoolean(reservationBO.saveReservation(reservationDTO));

        if (!isSaved){
            return false;
        }

        RoomDTO roomDTO=reservationDTO.getRoomDTO();
        roomDTO.setQty(roomDTO.getQty()-1);

        boolean isUpdate=reservationBO.updateRoomQty(roomDTO);

        if (!isUpdate){
            return false;
        }
        return true;
    }
    private ReservationDTO getData() throws Exception {

        String status="unPaid";
        if (cbxStatus.isSelected()){
            status="paid";
        }

        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        StudentDTO studentData= getStudentDTO();
        RoomDTO roomData=getRoomDTO();

        return new ReservationDTO(
                txtReservationID.getText(),
                sqlDate,
                status,
                studentData,
                roomData
        );
    }
}
