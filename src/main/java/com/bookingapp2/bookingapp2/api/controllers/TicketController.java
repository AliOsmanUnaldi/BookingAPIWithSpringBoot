package com.bookingapp2.bookingapp2.api.controllers;

import com.bookingapp2.bookingapp2.business.abstracts.TicketService;
import com.bookingapp2.bookingapp2.core.utilities.DataResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.Ticket;
import com.bookingapp2.bookingapp2.entity.dtos.AddTicketDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){

        super();
        this.ticketService=ticketService;
    }

    @PostMapping("/addTicket")
    public Result addTicket(@RequestBody AddTicketDto addTicketDto){
        return ticketService.addTicket(addTicketDto);
    }

    @GetMapping("/getAllTicketsByOwnerId")
    public List<Ticket> getAllTicketsByOwnerId(@RequestParam long ownerId){
        return ticketService.getAllByOwnerId(ownerId);
    }

    @DeleteMapping("/deleteTicketByTicketId/{ticketId}")
    public Result deleteTicketByTicketId(@PathVariable long ticketId){

        return ticketService.deleteTicket(ticketId);
    }

    @PostMapping("/updateTicket")
    public Result updateTicket(@RequestBody UpdateTicketDto updateTicketDto){

        return ticketService.updateTicket(updateTicketDto);
    }

    @GetMapping("/getTicketByTicketId")
    public Ticket getTicketByTicketId(@RequestParam long ticketId){

        return ticketService.getTicketByTicketId(ticketId);
    }
}
