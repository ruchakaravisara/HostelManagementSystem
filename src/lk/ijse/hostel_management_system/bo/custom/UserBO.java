package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.bo.SuperBO;
import lk.ijse.hostel_management_system.dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> loadAll() throws Exception;
    boolean saveUser(UserDTO usersDTO) throws Exception;
    boolean updateUser(UserDTO usersDTO) throws Exception;
    boolean deleteUser(UserDTO usersDTO) throws Exception;
    String generateNextUserID() throws Exception;
}
