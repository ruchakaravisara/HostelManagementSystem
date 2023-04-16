package lk.ijse.hostel_management_system.dao.custom;

import org.hibernate.Session;

public interface ReservationDAO {
    void setSession(Session session) throws Exception;
    boolean changeCheckBOXValue(String id,String status);
}
