package com.bookingapp2.bookingapp2.dataAccess;

import com.bookingapp2.bookingapp2.core.utilities.DataResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.Seat;
import com.bookingapp2.bookingapp2.entity.Ticket;
import com.bookingapp2.bookingapp2.entity.dtos.AddTicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketDao extends JpaRepository<Ticket,Long> {

    @Query("From Ticket where ticketId=:ticketId")
    Ticket getTicketByTicketId(long ticketId);

    @Query("From Ticket where ownerId=:ownerId")
    List<Ticket> getAllByOwnerId(long ownerId);

    List<Ticket> getTicketsByVehicleId(long vehicleId);


}
