package lk.ijse.hostel_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
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
}
