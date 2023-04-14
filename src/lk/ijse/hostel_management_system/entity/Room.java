package lk.ijse.hostel_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity

public class Room {
    @Id
    @Column(length = 10,name = "room_type_id")
    private String id;
    private String type;

    @Column(name = "key_money")
    private String keyMoney;

    @Column(name = "Qty")
    private int qty;
}
