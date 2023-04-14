package lk.ijse.hostel_management_system.bo;

import lk.ijse.hostel_management_system.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory BOFactory;
    public BOFactory(){}

    public static BOFactory getInstance(){
        if (BOFactory == null){
            BOFactory = new BOFactory();

        }
        return BOFactory;
    }
    public enum BOTypes{
        Student,Rooms,Reservation,Users
    }
    public static SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case Student: return (SuperBO) new StudentBOImpl();
            case Reservation:
                return (SuperBO) new ReservationBOImpl();
            case Rooms:
                return (SuperBO) new RoomBOImpl();
            case Users:
                return (SuperBO) new UserBOImpl();
            default:
                return null;
        }
    }
}
