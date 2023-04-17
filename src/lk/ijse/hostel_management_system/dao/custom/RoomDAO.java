package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.dao.CrudDAO;
import lk.ijse.hostel_management_system.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room> {
    void setSession(Session session) throws Exception;
    List<String> getIds() throws Exception;
}
