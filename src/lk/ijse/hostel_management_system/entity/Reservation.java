package lk.ijse.hostel_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @Column(name = "reservationId",length = 10)
    private String resId;

    private Date date;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "roomTypeId")
    private Room room;

    public Reservation(String resId, Date date, String status) {
    }

    public Reservation(String resId, Date date, String status, Student student, Room room) {
        this.resId = resId;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }

    public Reservation() {

    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
    }
}
