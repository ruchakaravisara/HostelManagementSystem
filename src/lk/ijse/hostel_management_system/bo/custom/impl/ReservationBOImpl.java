package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.ReservationBO;
import lk.ijse.hostel_management_system.dao.DAOFactory;
import lk.ijse.hostel_management_system.dao.custom.QueryDAO;
import lk.ijse.hostel_management_system.dao.custom.ReservationDAO;
import lk.ijse.hostel_management_system.dao.custom.RoomDAO;
import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import lk.ijse.hostel_management_system.dto.ReservationDTO;
import lk.ijse.hostel_management_system.dto.RoomDTO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.entity.Reservation;
import lk.ijse.hostel_management_system.entity.Room;
import lk.ijse.hostel_management_system.entity.Student;
import lk.ijse.hostel_management_system.projection.StudentDetailsDTO;
import lk.ijse.hostel_management_system.util.SessionFactoryConfigaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO= (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Reservation);
    StudentDAO studentDAO= (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Student);
    RoomDAO roomDAO= (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Rooms);
    QueryDAO queryDAO= (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Query);

    private Session session;


    @Override
    public List<ReservationDTO> loadAll() throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        reservationDAO.setSession(session);
        List<Reservation>reservations= reservationDAO.loadAll();
        List<ReservationDTO>reservationDTOS=new ArrayList<>();
        for (Reservation reservation :reservations){
            reservationDTOS.add(
                    new ReservationDTO(
                            reservation.getResId(),
                            reservation.getDate(),
                            reservation.getStatus(),

                    new StudentDTO(reservation.getStudent().getId(),
                            reservation.getStudent().getName(),
                            reservation.getStudent().getAddress(),
                            reservation.getStudent().getContactNo(),
                            reservation.getStudent().getDob(),
                            reservation.getStudent().getGender()
                            ),
                    new RoomDTO(
                            reservation.getRoom().getId(),
                            reservation.getRoom().getType(),
                            reservation.getRoom().getKeyMoney(),
                            reservation.getRoom().getQty())));
        }
        return  reservationDTOS;
    }

    @Override
    public String saveReservation(ReservationDTO reservationDTO) throws Exception  {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.save(new Reservation(
                            reservationDTO.getResId(),
                            reservationDTO.getDate(),
                            reservationDTO.getStatus(),
                            new Student(
                                   reservationDTO.getStudentDTO().getId(),
                                    reservationDTO.getStudentDTO().getName(),
                                    reservationDTO.getStudentDTO().getAddress(),
                                    reservationDTO.getStudentDTO().getContactNo(),
                                    reservationDTO.getStudentDTO().getDob(),
                                    reservationDTO.getStudentDTO().getGender()
                            ),
                            new Room(
                                    reservationDTO.getRoomDTO().getId(),
                                    reservationDTO.getRoomDTO().getType(),
                                    reservationDTO.getRoomDTO().getKeyMoney(),
                                    reservationDTO.getRoomDTO().getQty()
                            )
                    )
            );
            transaction.commit();
            session.close();
            return String.valueOf(true);
        }catch (Exception e){
            transaction.rollback();
            session.close();
            return null;
        }
    }

    @Override
    public StudentDTO getStudent(String id) {
       try{
           session =SessionFactoryConfigaration.getInstance().getSession();
           Transaction transaction =session.beginTransaction();
           studentDAO.setSession(session);
           Student student = studentDAO.getObject(id);
           transaction.commit();
           session.close();

           return new StudentDTO(
                   student.getId(),
                   student.getName(),
                   student.getAddress(),
                   student.getContactNo(),
                   student.getDob(),
                   student.getGender()
           );

       } catch (Exception e) {
           session.close();
           return null;
       }
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            reservationDAO.setSession(session);
            reservationDAO.update(new Reservation(
                    reservationDTO.getResId(),
                    reservationDTO.getDate(),
                    reservationDTO.getStatus(),

                    new Student(
                            reservationDTO.getStudentDTO().getId(),
                            reservationDTO.getStudentDTO().getName(),
                            reservationDTO.getStudentDTO().getAddress(),
                            reservationDTO.getStudentDTO().getContactNo(),
                            reservationDTO.getStudentDTO().getDob(),
                            reservationDTO.getStudentDTO().getGender()
                    ),
                    new Room(
                            reservationDTO.getRoomDTO().getId(),
                            reservationDTO.getRoomDTO().getType(),
                            reservationDTO.getRoomDTO().getKeyMoney(),
                            reservationDTO.getRoomDTO().getQty()
                    )
            )
            );
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public RoomDTO getRoom(String id) {
        try {
            session= SessionFactoryConfigaration.getInstance().getSession();
            Transaction transaction=session.beginTransaction();
            roomDAO.setSession(session);
            Room room=roomDAO.getObject(id);
            transaction.commit();
            session.close();
            return new RoomDTO(
                    room.getId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()
            );
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    @Override
    public boolean deleteReservation(ReservationDTO reservationDTO) {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            reservationDAO.setSession(session);
            reservationDAO.delete(new Reservation(
                    reservationDTO.getResId(),
                    reservationDTO.getDate(),
                    reservationDTO.getStatus())
            );
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public String generateNextReservationID() throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        reservationDAO.setSession(session);
        return reservationDAO.generateID();
    }


    @Override
    public List<String> getStudentIds() {
       try {
           session=SessionFactoryConfigaration.getInstance().getSession();
           studentDAO.setSession(session);
           session.close();
           return studentDAO.getIds();
       } catch (Exception e) {
           session.close();
           return null;
       }
    }

    @Override
    public List<String> getRoomIds() {
    try {
        session=SessionFactoryConfigaration.getInstance().getSession();
        roomDAO.setSession(session);
        return roomDAO.getIds();
    } catch (Exception e) {
        session.close();
        return null;
    }
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        studentDAO.setSession(session);
        List<Student> allStudent = studentDAO.loadAll();
        List<StudentDTO>studentDTOList=new ArrayList<>();
        for (Student student :allStudent){
            studentDTOList.add(new StudentDTO(

                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContactNo(),
                    student.getDob(),
                    student.getGender())
            );
        }
        return studentDTOList;
    }

    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        session= SessionFactoryConfigaration.getInstance().getSession();
        roomDAO.setSession(session);
        List<Room>allRooms=roomDAO.loadAll();
        List<RoomDTO>roomDTOS=new ArrayList<>();
        for (Room room : allRooms){

            roomDTOS.add(new RoomDTO(
                    room.getId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty())
            );
        }
        return roomDTOS;
    }

    @Override
    public boolean updateRoomQty(RoomDTO roomDTO) {
        session= SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            roomDAO.setSession(session);

            roomDAO.update(new Room(
                    roomDTO.getId(),
                    roomDTO.getType(),
                    roomDTO.getKeyMoney(),
                    roomDTO.getQty())
            );
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean checkStatusClick(String id, String status) {
        session=SessionFactoryConfigaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        boolean isUpdate=false;

        try {
            reservationDAO.setSession(session);
            isUpdate =reservationDAO.changeCheckBOXValue(id,status);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
        }
        return isUpdate;
    }

    @Override
    public List<StudentDetailsDTO> getAllProjection() {
        session=SessionFactoryConfigaration.getInstance().getSession();
        return queryDAO.getAllStudentProjection();

    }
}
