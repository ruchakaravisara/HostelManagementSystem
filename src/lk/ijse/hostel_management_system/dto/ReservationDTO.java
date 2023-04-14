package lk.ijse.hostel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReservationDTO {
    private String resId;
    private Date date;
    private String status;
    private StudentDTO studentDTO;
    private RoomDTO roomDTO;
    private String studentId;
    private String roomId;
}
