package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dao.DAOFactory;
import lk.ijse.hostel_management_system.dao.custom.UserDAO;
import lk.ijse.hostel_management_system.dto.UserDTO;
import lk.ijse.hostel_management_system.entity.User;
import lk.ijse.hostel_management_system.util.SessionFactoryConfigaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Users);
    private Session session;
    @Override
    public List<UserDTO> loadAll() throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        userDAO.setSession(session);

        List<User> users = userDAO.loadAll();
        List<UserDTO> usersDTOS=new ArrayList<>();

        for (User users1:users) {
            usersDTOS.add(
                    new UserDTO(
                            users1.getId(),
                            users1.getUserName(),
                            users1.getPassword(),
                            users1.getContact()

                    )
            );
        }

        return usersDTOS;
    }

    @Override
    public boolean saveUser(UserDTO usersDTO) throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            userDAO.setSession(session);
            userDAO.save(
                    new User(
                            usersDTO.getId(),
                            usersDTO.getUserName(),
                            usersDTO.getPassword(),
                            usersDTO.getContact()

                    )
            );
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            transaction.rollback();
            session.close();
        }

        return false;
    }

    @Override
    public boolean updateUser(UserDTO usersDTO) throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.update(
                    new User(
                            usersDTO.getId(),
                            usersDTO.getUserName(),
                            usersDTO.getPassword(),
                            usersDTO.getContact()

                    )
            );
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
        }

        return false;
    }

    @Override
    public boolean deleteUser(UserDTO usersDTO) throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.delete(
                    new User(
                            usersDTO.getId(),
                            usersDTO.getUserName(),
                            usersDTO.getPassword(),
                            usersDTO.getContact()

                    )

            );
            transaction.commit();
            session.close();

            return true;

        }catch (Exception e){
            transaction.rollback();
            session.close();
        }

        return false;
        }


    @Override
    public String generateNextUserID() throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        userDAO.setSession(session);
        return userDAO.generateID();
    }
}
