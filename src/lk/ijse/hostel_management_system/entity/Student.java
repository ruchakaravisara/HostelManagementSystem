package lk.ijse.hostel_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Student {
    @Id
    @Column(length = 10,name = "studentID")
    private String id;
    private String name;
    private String address;
    private String contactNo;
    private String dob;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "student")
    private List<Reservation> reservationList=new ArrayList<>();

    public Student(String id, String name, String address, String contactNo, String dob, String gender) {
    }
}
