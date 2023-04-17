package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.RoomBO;
import lk.ijse.hostel_management_system.dto.RoomDTO;

import java.util.List;

public class RoomBOImpl implements RoomBO {
    @Override
    public List<RoomDTO> loadAllRoom() {
        return null;
    }

    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public String generateNextRoomID() {
        return null;
    }
}
