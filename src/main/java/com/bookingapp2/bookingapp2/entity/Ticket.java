package com.bookingapp2.bookingapp2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long ticketId;

    @Column(name = "status")
    private boolean status;

    @Column(name = "owner_id")
    private long ownerId;

    @Column(name = "seat_id")
    private long seatId;

    @Column(name = "vehicle_id")
    private long vehicleId;
}
