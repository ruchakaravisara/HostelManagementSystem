package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.dao.SuperDAO;
import lk.ijse.hostel_management_system.projection.StudentDetailsDTO;

import java.util.List;

public interface QueryDAO  extends SuperDAO {
    List<StudentDetailsDTO> getAllStudentProjection();
}
