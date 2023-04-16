package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import org.hibernate.Session;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void setSession(Session session) throws Exception {

    }

    @Override
    public List<String> getIds() throws Exception {
        return null;
    }
}
