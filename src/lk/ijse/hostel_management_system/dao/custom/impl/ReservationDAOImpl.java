package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.ReservationDAO;
import lk.ijse.hostel_management_system.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private Session session;
    @Override
    public void setSession(Session session) throws Exception {
        this.session =session;
    }

    @Override
    public boolean changeCheckBOXValue(String id, String status) {

       String hql ="update Reservation r set r.status =:sts WHERE r.resId =:rid";
        Query query = session.createQuery(hql);
        query.setParameter("sts",status);
        query.setParameter("rid",id);
        int value = query.executeUpdate();
        return value>=0;
    }
    public String generateID(){
        String sql ="FROM Reservation ORDER BY id DESC";
        Reservation reservation = (Reservation) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();
        if(reservation != null){
            String lastId =reservation.getResId();
            int newCustomerId = Integer.parseInt(lastId.replace("RE-", "")) + 1;
            return String.format("RE-%03d",newCustomerId);
        }
        return "RE-001";
    }
    public Reservation getObject(String id){
        return session.get(Reservation.class,id);
    }
    public void delete(Reservation reservation){
        session.delete(reservation);
    }
    public String save(Reservation reservation){
        return (String) session.save(reservation);
    }
    public void update(Reservation reservation) throws Exception {
        session.update(reservation);
    }
    public List<Reservation> loadAll() throws Exception {
        try{
            String sqlQuery="From Reservation ";
            Query query = session.createQuery(sqlQuery);
            List list = query.list();
            session.close();
            return list;
        }catch (Exception e){

        }
        return null;
    }
}
