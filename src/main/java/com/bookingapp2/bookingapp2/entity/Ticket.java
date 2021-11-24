package com.bookingapp2.bookingapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long ticketId;

    @Column(name = "status")
    private boolean status;

    @Column(name = "owner_id",nullable = false)
    private long ownerId;

    @Column(name = "seat_id",unique = true)
    private long seatId;

    @Column(name = "vehicle_id",nullable = false)
    private long vehicleId;

    public Ticket(long ownerId, long vehicleId, long seatId, boolean status) {

        this.ownerId=ownerId;
        this.vehicleId=vehicleId;
        this.seatId=seatId;
        this.status=status;
    }
}
