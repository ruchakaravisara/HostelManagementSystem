package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentFormController {

    public JFXButton btnAddStudent;
    public JFXButton btnDelete;
    public JFXButton btnSave;
    public TableView <StudentDTO> tblStudent;
    public TableColumn<StudentDTO,String> colID;
    public JFXTextField txtName;
    public TableColumn <StudentDTO, String>colName;
    public TableColumn<StudentDTO, String> colAddress;
    public TableColumn <StudentDTO, String>colContact;
    public TableColumn<StudentDTO, String> colGender;
    public TableColumn<StudentDTO, String> colDOB;
    public Label lblStudentID;
    public JFXTextField txtGender;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtDOB;
    public JFXButton btnUpdate;
    public JFXTextField txtSid;

    StudentBO studentBO =(StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Student);

    public void initialize(){
        loadAllStudents();
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    public void iniUI(){
        txtSid.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        txtDOB.setDisable(true);
        txtGender.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);

    }

    public void loadAllStudents(){
        tblStudent.getItems().clear();

        try {
            ArrayList<StudentDTO> arrayList= (ArrayList<StudentDTO>) studentBO.loadAll();
            for (StudentDTO s:arrayList){
                tblStudent.getItems().add(new StudentDTO(s.getId(),s.getName(),s.getAddress(),s.getContactNo(),s.getDob(),s.getGender()));
            }
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
        }
    }
    public void clear(){
            txtSid.clear();
            txtName.clear();
            txtAddress.clear();
            txtContact.clear();
            txtDOB.clear();
            txtGender.clear();
    }

    void getData(){
        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue != null) {
                txtSid.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtDOB.setText(newValue.getDob());
                txtContact.setText(newValue.getContactNo());
                txtGender.setText(newValue.getDob());

            }
        });
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(
                txtSid.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                txtDOB.getText(),
                txtGender.getText()
        );

        System.out.println(studentDTO);
        try {
            boolean isDeleted = studentBO.deleteStudent(
                    studentDTO
            );

            if (isDeleted){

                new Alert(Alert.AlertType.CONFIRMATION, "Student Delete Successfully!").show();
                clear();
                tblStudent.getItems().clear();
                loadAllStudents();

            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        }catch (Exception e){

        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {
            String saveID = studentBO.saveStudent(
                    new StudentDTO(
                            txtSid.getText(),
                            txtName.getText(),
                            txtAddress.getText(),
                            txtContact.getText(),
                            txtDOB.getText(),
                            txtGender.getText()
                    )
            );
            System.out.println(studentBO);

            if (saveID!=null){
                clear();
                new Alert(Alert.AlertType.CONFIRMATION, "Student Save Successfully!").show();
                tblStudent.getItems().clear();
                loadAllStudents();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO studentDTO = new StudentDTO(
                txtSid.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                txtDOB.getText(),
                txtGender.getText()
        );

        System.out.println(studentDTO);

        boolean isUpdate =  studentBO.updateStudent(studentDTO);


        if (isUpdate) {

            new Alert(Alert.AlertType.CONFIRMATION, "Student Update Successfully!").show();
            clear();
            tblStudent.getItems().clear();
            loadAllStudents();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }
}
