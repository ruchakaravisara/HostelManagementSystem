package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.util.List;

public class StudentBOImpl implements StudentBO {
    @Override
    public List<StudentDTO> loadAll() throws Exception {
        return null;
    }

    @Override
    public String saveStudent(StudentDTO studentDTO) throws Exception {
        return null;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) throws Exception {
        return false;
    }

    @Override
    public String generateNextStudentID() throws Exception {
        return null;
    }
}
