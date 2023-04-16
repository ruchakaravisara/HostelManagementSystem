package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.RoomDAO;
import lk.ijse.hostel_management_system.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private Session session;
    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public List<String> getIds() throws Exception {
        String hql ="select id from Room";
        Query<String> query = session.createQuery(hql);
        List<String> results = query.list();
        session.close();
        return results;
    }
    public String generateID(){
        Room room =null;
        try {
            String sqlQuery ="FROM Reservation ORDER BY id DESC";
            Query query = session.createQuery(sqlQuery);
            query.setMaxResults(1);
            room = (Room) query.uniqueResult();
        }catch (Exception e){
            System.out.println(e);
        }
        String lastID=room.getId();
        if (lastID != null){ int newRoomID=Integer.parseInt(lastID.replace("RM-",""))+1;
            return String.format("RM-%03d",newRoomID);}
        return "RM-001";
    }
    public Room getObject(String id){
        return session.get(Room.class,id);
    }

    public void delete(Room room){
        session.delete(room);
    }
    public void update(Room room){
        session.delete(room);
    }
    public List<Room> loadAll() throws Exception {
        String sqlQuery="From Room ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }


    public String save(Room room) throws Exception {
        return (String) session.save(room);
    }

}
