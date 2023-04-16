package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import lk.ijse.hostel_management_system.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;
    @Override
    public void setSession(Session session) throws Exception {
        this.session =session;
    }

    @Override
    public List<String> getIds() throws Exception {
        String hql = "select id from Student";
        Query<String> query = session.createQuery(hql);
        List<String> results = query.list();
        session.close();
        return results;
    }
    public String generateID() throws Exception {
        Student student = null;
        try {
            String sqlQuery="FROM Reservation ORDER BY id DESC";
            Query query = session.createQuery(sqlQuery);
            query.setMaxResults(1);
            student = (Student) query.uniqueResult();
        }catch (Exception e){

        }

        String lastID=student.getId();

        if (lastID != null){
            int newStudentID=Integer.parseInt(lastID.replace("S-",""))+1;
            return String.format("S-%03d",newStudentID);
        }
        return "S-001";
    }
    public Student getObject(String id){
        return session.get(Student.class,id);
    }


    public String save(Student student) throws Exception {
        return (String) session.save(student);
    }


    public void update(Student student) throws Exception {
        session.update(student);
    }


    public void delete(Student student) throws Exception {
        session.delete(student);
    }
    public List<Student> loadAll() throws Exception {
        String sqlQuery="From Student ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }
}
