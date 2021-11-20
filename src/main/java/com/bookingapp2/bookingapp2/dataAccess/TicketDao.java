package com.bookingapp2.bookingapp2.dataAccess;

import com.bookingapp2.bookingapp2.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket,Long> {
}
