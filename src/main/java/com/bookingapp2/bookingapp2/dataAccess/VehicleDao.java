package com.bookingapp2.bookingapp2.dataAccess;

import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleDao extends JpaRepository<Vehicle,Long> {

        @Query("Select vehicleId From Vehicle where numberPlate=:numberPlate")
        long getVehicleIdByNumberPlate(String numberPlate);

        Vehicle getById(long vehicleId);


}
