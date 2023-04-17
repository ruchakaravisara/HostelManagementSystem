package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.dao.CrudDAO;
import lk.ijse.hostel_management_system.entity.Reservation;
import org.hibernate.Session;

public interface ReservationDAO  extends CrudDAO<Reservation> {
    void setSession(Session session) throws Exception;
    boolean changeCheckBOXValue(String id,String status);
}
