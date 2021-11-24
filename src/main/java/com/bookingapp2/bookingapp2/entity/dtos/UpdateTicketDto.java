package com.bookingapp2.bookingapp2.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTicketDto {

    private long ticketId;

    private boolean status;

    private long ownerId;

    private long seatId;

    private long vehicleId;
}
