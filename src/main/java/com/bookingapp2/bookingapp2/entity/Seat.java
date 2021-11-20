package com.bookingapp2.bookingapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "seats")
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private long seatId;

    @Column(name = "vehicle_id")
    private long vehicleId;

    @Column(name = "seat_no")
    private int seatNo;

    public Seat(long vehicleId, int seatNo) {

        this.vehicleId=vehicleId;
        this.seatNo=seatNo;
    }
}
