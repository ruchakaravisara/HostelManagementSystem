package lk.ijse.hostel_management_system.projection;

import lk.ijse.hostel_management_system.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDetailsDTO {
    private String studentId;
    private String name;
    private String contact;
    private Date date;
    private String resId;
    private String roomId;
    private Room room;

    /*public void setRoom(Room room){
        this.room =room;
        roomId=room.getId();
    }*/
}
