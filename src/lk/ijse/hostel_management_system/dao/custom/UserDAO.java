package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.dao.CrudDAO;
import lk.ijse.hostel_management_system.entity.User;
import org.hibernate.Session;

public interface UserDAO extends CrudDAO<User> {
    void setSession(Session session) throws Exception;
}
