package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.ReservationDTO;
import lk.ijse.hostel_management_system.dto.RoomDTO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.projection.StudentDetailsDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<ReservationDTO> loadAll()  throws Exception;
    String saveReservation(ReservationDTO reservationDTO) throws Exception;
    StudentDTO getStudent(String id) throws Exception;
    boolean updateReservation(ReservationDTO reservationDTO) ;
    RoomDTO getRoom(String id) throws Exception;
    boolean deleteReservation(ReservationDTO reservationDTO);
    String generateNextReservationID() throws Exception;
    List<String> getStudentIds() ;
    List<String> getRoomIds() ;
    List<StudentDTO> getAllStudent() throws Exception;
    List<RoomDTO> getAllRoom() throws Exception;
    boolean updateRoomQty(RoomDTO roomDTO) throws Exception;
    boolean checkStatusClick(String id,String status) throws Exception;
    List<StudentDetailsDTO> getAllProjection() throws Exception;
}
