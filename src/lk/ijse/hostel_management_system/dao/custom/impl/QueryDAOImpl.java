package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.QueryDAO;
import lk.ijse.hostel_management_system.projection.StudentDetailsDTO;
import lk.ijse.hostel_management_system.util.SessionFactoryConfigaration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    private Session session;

    @Override
    public List<StudentDetailsDTO> getAllStudentProjection() {
        session = SessionFactoryConfigaration.getInstance().getSession();
        String sql ="SELECT new lk.ijse.hostel_management_system.projection.StudentDetailsDTO(s.id,s.name,s.contactNo,r.date,r.id,r.room) FROM Student s INNER join s.reservationList r WHERE r.status='unPaid'";

        Query query = session.createQuery(sql);
        List <StudentDetailsDTO> list = query.list();
        session.close();
        return list;
    }
}
