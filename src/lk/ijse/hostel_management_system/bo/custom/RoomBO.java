package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO>loadAllRoom() throws Exception;
    boolean saveRoom(RoomDTO roomDTO) throws Exception;
    boolean updateRoom(RoomDTO roomDTO) throws Exception;
    boolean deleteRoom(RoomDTO roomDTO) throws Exception;
    String generateNextRoomID() throws Exception;
}
