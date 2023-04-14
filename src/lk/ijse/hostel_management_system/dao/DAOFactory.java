package lk.ijse.hostel_management_system.dao;

import lk.ijse.hostel_management_system.dao.custom.impl.*;

public class DAOFactory {
     public static DAOFactory daoFactory;
     public DAOFactory(){}

    public static DAOFactory getDaoFactory(){
         if (daoFactory == null){
             daoFactory = new DAOFactory();
         }
         return daoFactory;
    }
    public enum DAOTypes{
        Student,Rooms,Reservation,Users,Query
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
         switch (daoTypes){
             case Student :
                 return (SuperDAO) new StudentDAOImpl();
             case Rooms:
                 return (SuperDAO) new RoomDAOImpl();
             case Reservation:
                 return (SuperDAO) new ReservationDAOImpl();
             case Users:
                 return (SuperDAO) new UserDAOImpl();
             case Query:
                 return (SuperDAO) new QueryDAOImpl();

             default:
                 return null;
         }
    }
}
