package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO>loadAllRoom();
    boolean saveRoom(RoomDTO roomDTO);
    boolean updateRoom(RoomDTO roomDTO);
    boolean deleteRoom(RoomDTO roomDTO);
    String generateNextRoomID();
}
