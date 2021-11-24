package com.bookingapp2.bookingapp2.business.concretes;

import com.bookingapp2.bookingapp2.business.abstracts.TicketService;
import com.bookingapp2.bookingapp2.core.utilities.*;
import com.bookingapp2.bookingapp2.dataAccess.SeatDao;
import com.bookingapp2.bookingapp2.dataAccess.TicketDao;
import com.bookingapp2.bookingapp2.dataAccess.UserDao;
import com.bookingapp2.bookingapp2.entity.Ticket;
import com.bookingapp2.bookingapp2.entity.User;
import com.bookingapp2.bookingapp2.entity.dtos.AddTicketDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateTicketDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketManager implements TicketService {

    private TicketDao ticketDao;
    private UserDao userDao;
    private SeatDao seatDao;

    @Autowired
    public TicketManager(TicketDao ticketDao,UserDao userDao,SeatDao seatDao){

        super();
        this.ticketDao=ticketDao;
        this.userDao=userDao;
        this.seatDao=seatDao;
    }

    @Override
    public Ticket getByTicketId(long ticketId) {

        return ticketDao.getByTicketId(ticketId);
    }

    @Override
    public Result addTicket(AddTicketDto addTicketDto) {

        try {
            Ticket ticket=new Ticket(
                    addTicketDto.getOwnerId(),addTicketDto.getVehicleId(),
                    addTicketDto.getSeatId(),addTicketDto.isStatus());

            ticketDao.save(ticket);
            return new SuccessResult("Bilet eklendi.");
        }
        catch (Exception e){
            return new ErrorResult(false,e.getMessage());
        }

    }

    @Override
    public List<Ticket> getAllByOwnerId(long ownerId) {
        //return new SuccessDataResult<>((List<Ticket>) this.ticketDao.getAllByOwnerId(ownerId),"Biletleriniz listelendi.");
        return ticketDao.getAllByOwnerId(ownerId);
    }

    @Override
    public Result deleteTicket(long ticketId) {

        try {
            ticketDao.deleteById(ticketId);
            return new SuccessResult("Bilet silindi.");
        }
        catch (Exception e){
            return new ErrorResult(false, e.getMessage());
        }
    }

    @Override
    public Result updateTicket(UpdateTicketDto updateTicketDto) {


            try {
                Ticket ticket = ticketDao.getByTicketId(updateTicketDto.getTicketId());
                ticket.setSeatId(updateTicketDto.getSeatId());
                ticket.setStatus(updateTicketDto.isStatus());
                ticket.setVehicleId(updateTicketDto.getVehicleId());
                ticket.setOwnerId(updateTicketDto.getOwnerId());

                ticketDao.save(ticket);
                return new SuccessResult("Bilet güncellendi.");
            }

            catch (Exception e) {
                return new ErrorResult(false, e.getMessage());
            }

    }
}
