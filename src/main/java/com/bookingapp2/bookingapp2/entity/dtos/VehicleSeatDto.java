package com.bookingapp2.bookingapp2.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSeatDto {

    private long userId;

    private String numberPlate;

    private String date;

    private String currentPlace;

    private String destinationPlace;

    private int seatCount;


}
