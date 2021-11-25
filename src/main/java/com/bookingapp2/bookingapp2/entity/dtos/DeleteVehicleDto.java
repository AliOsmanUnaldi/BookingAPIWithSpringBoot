package com.bookingapp2.bookingapp2.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteVehicleDto {

    private long vehicleId;

    private long userId;
}
