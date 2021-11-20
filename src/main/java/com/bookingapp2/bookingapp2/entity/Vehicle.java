package com.bookingapp2.bookingapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private long vehicleId;

    @Column(name = "number_plate",unique = true,nullable = false)
    private String numberPlate;

    @Column(name = "date")
    private String date;

    @Column(name = "current_place")
    private String currentPlace;

    @Column(name = "destination_place")
    private String destinationPlace;


    public Vehicle(String numberPlate,String date,String currentPlace,String destinationPlace){

        this.numberPlate=numberPlate;
        this.date=date;
        this.currentPlace=currentPlace;
        this.destinationPlace=destinationPlace;
    }
}
