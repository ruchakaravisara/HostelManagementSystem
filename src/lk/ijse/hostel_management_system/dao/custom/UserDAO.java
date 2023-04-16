package lk.ijse.hostel_management_system.dao.custom;

import org.hibernate.Session;

public interface UserDAO {
    void setSession(Session session) throws Exception;
}
