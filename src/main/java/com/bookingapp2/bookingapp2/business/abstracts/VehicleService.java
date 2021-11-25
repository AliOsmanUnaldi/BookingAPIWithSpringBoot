package com.bookingapp2.bookingapp2.business.abstracts;

import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.Seat;
import com.bookingapp2.bookingapp2.entity.Ticket;
import com.bookingapp2.bookingapp2.entity.Vehicle;
import com.bookingapp2.bookingapp2.entity.dtos.DeleteVehicleDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateVehicleDto;
import com.bookingapp2.bookingapp2.entity.dtos.VehicleSeatDto;

import java.util.List;


public interface VehicleService {

        Result addVehicle(VehicleSeatDto vehicleSeatDto);

        Result updateVehicle(UpdateVehicleDto updateVehicleDto);

        long getVehicleIdByNumberPlate(String numberPlate);

        Vehicle getVehicleById(long vehicleId);

        Result deleteVehicleById(DeleteVehicleDto deleteVehicleDto);

        List<Seat> getSeatsByVehicleId(long vehicleId);

        List<Ticket> getTicketsByVehicleId(long vehicleId);



}
