package com.bookingapp2.bookingapp2.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTicketDto {

    private boolean status;

    private long ownerId;

    private long vehicleId;

    private long seatId;
}
