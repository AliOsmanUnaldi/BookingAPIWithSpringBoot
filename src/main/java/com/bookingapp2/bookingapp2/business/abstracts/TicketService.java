package com.bookingapp2.bookingapp2.business.abstracts;

import com.bookingapp2.bookingapp2.core.utilities.DataResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.Ticket;
import com.bookingapp2.bookingapp2.entity.dtos.AddTicketDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateTicketDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateUserDto;

import java.util.List;

public interface TicketService {

    Ticket getByTicketId(long ticketId);

    Result addTicket(AddTicketDto addTicketDto);

    List<Ticket> getAllByOwnerId(long ownerId);

    Result deleteTicket(long ticketId);

    Result updateTicket(UpdateTicketDto updateTicketDto);

}
