package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.ReservationDAO;
import org.hibernate.Session;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public void setSession(Session session) throws Exception {

    }

    @Override
    public boolean changeCheckBOXValue(String id, String status) {
        return false;
    }
}
