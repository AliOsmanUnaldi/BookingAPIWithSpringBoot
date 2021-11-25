package com.bookingapp2.bookingapp2.api.controllers;

import com.bookingapp2.bookingapp2.business.abstracts.VehicleService;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.core.utilities.SuccessResult;
import com.bookingapp2.bookingapp2.entity.Vehicle;
import com.bookingapp2.bookingapp2.entity.dtos.DeleteVehicleDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateVehicleDto;
import com.bookingapp2.bookingapp2.entity.dtos.VehicleSeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){

        super();
        this.vehicleService=vehicleService;
    }

    @RequestMapping("/getVehicleByVehicleId")
    public Vehicle getVehicleByVehicleId(@RequestParam long vehicleId){

        return this.vehicleService.getVehicleById(vehicleId);
    }

    @PostMapping("/addVehicle")
    public Result addVehicle(@RequestBody VehicleSeatDto vehicleSeatDto){

        return this.vehicleService.addVehicle(vehicleSeatDto);
    }

    @RequestMapping(value = "/deleteVehicleById/{vehicleId}/{userId}",method = RequestMethod.DELETE)
    public Result deleteVehicleById(@PathVariable("vehicleId") long vehicleId, @PathVariable("userId") long userId){

        DeleteVehicleDto deleteVehicleDto=new DeleteVehicleDto(vehicleId,userId);

        return this.vehicleService.deleteVehicleById(deleteVehicleDto);
    }

    @PostMapping("/updateVehicle")
    public Result updateVehicle(@RequestBody UpdateVehicleDto updateVehicleDto){

        return  this.vehicleService.updateVehicle(updateVehicleDto);
    }
}
