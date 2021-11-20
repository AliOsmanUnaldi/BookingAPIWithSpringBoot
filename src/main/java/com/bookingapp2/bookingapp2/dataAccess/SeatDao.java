package com.bookingapp2.bookingapp2.dataAccess;

import com.bookingapp2.bookingapp2.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatDao extends JpaRepository<Seat,Long> {

    List<Seat> getSeatsByVehicleId(long vehicleId);



}
