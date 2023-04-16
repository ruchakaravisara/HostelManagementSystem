package lk.ijse.hostel_management_system.dao.custom;

import org.hibernate.Session;

import java.util.List;

public interface RoomDAO {
    void setSession(Session session) throws Exception;
    List<String> getIds() throws Exception;
}
