package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.dao.CrudDAO;
import lk.ijse.hostel_management_system.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    void setSession(Session session) throws Exception;
    List<String> getIds() throws Exception;
}
