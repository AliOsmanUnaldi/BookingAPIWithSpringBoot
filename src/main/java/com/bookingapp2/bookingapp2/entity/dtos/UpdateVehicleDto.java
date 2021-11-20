package com.bookingapp2.bookingapp2.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleDto {

    private long userId;

    private long vehicleId;

    private String numberPlate;

    private String date;

    private String currentPlace;

    private String destinationPlace;
}
