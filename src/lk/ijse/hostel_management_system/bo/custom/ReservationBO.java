package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.ReservationDTO;
import lk.ijse.hostel_management_system.dto.RoomDTO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.projection.StudentDetailsDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<ReservationDTO> loadAll();
    String saveReservation(ReservationDTO reservationDTO);
    StudentDTO getStudent(String id);
    boolean updateReservation(ReservationDTO reservationDTO);
    RoomDTO getRoom(String id);
    boolean deleteReservation(ReservationDTO reservationDTO);
    String generateNextReservationID();
    List<String> getStudentIds();
    List<String> getRoomIds();
    List<StudentDTO> getAllStudent();
    List<RoomDTO> getAllRoom();
    boolean updateRoomQty(RoomDTO roomDTO);
    boolean checkStatusClick(String id,String status);
    List<StudentDetailsDTO> getAllProjection();
}
