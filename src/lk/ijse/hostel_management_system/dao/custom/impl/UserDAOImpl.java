package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.UserDAO;
import lk.ijse.hostel_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Session session;
    @Override
    public void setSession(Session session) throws Exception {
    this.session=session;
    }

    public List<User> loadAll() throws Exception {
        String sqlQuery="From User ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }


    public String save(User users) throws Exception {
        return (String) session.save(users);
    }


    public void update(User users) throws Exception {
        session.update(users);
    }


    public void delete(User users) throws Exception {
        session.delete(users);
    }


    public User getObject(String id) throws Exception {
        return session.get(User.class,id);
    }


    public String generateID() throws Exception {
        String sql="FROM User ORDER BY id DESC";
        User student= (User) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();
        if (student!=null){
            String lastId=student.getId();
            int newCustomerId=Integer.parseInt(lastId.replace("U00-",""))+1;
            return String.format("U00-%03d",newCustomerId);
        }
        return "U00-001";
    }
}
