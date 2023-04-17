package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dto.UserDTO;

import java.util.List;

public class UserBOImpl implements UserBO {
    @Override
    public List<UserDTO> loadAll() throws Exception {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO usersDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateUser(UserDTO usersDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUser(UserDTO usersDTO) throws Exception {
        return false;
    }

    @Override
    public String generateNextUserID() throws Exception {
        return null;
    }
}
