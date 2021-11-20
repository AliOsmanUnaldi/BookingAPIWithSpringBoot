package com.bookingapp2.bookingapp2.business.concretes;

import com.bookingapp2.bookingapp2.business.abstracts.VehicleService;
import com.bookingapp2.bookingapp2.core.utilities.ErrorResult;
import com.bookingapp2.bookingapp2.core.utilities.Result;
import com.bookingapp2.bookingapp2.core.utilities.SuccessResult;
import com.bookingapp2.bookingapp2.dataAccess.SeatDao;
import com.bookingapp2.bookingapp2.dataAccess.UserDao;
import com.bookingapp2.bookingapp2.dataAccess.VehicleDao;
import com.bookingapp2.bookingapp2.entity.Seat;
import com.bookingapp2.bookingapp2.entity.Vehicle;
import com.bookingapp2.bookingapp2.entity.dtos.DeleteVehicleDto;
import com.bookingapp2.bookingapp2.entity.dtos.UpdateVehicleDto;
import com.bookingapp2.bookingapp2.entity.dtos.VehicleSeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VehicleManager implements VehicleService {

    private VehicleDao vehicleDao;
    private SeatDao seatDao;
    private UserDao userDao;

    @Autowired
    public VehicleManager(VehicleDao vehicleDao, SeatDao seatDao,UserDao userDao){

        super();
        this.vehicleDao=vehicleDao;
        this.seatDao=seatDao;
        this.userDao=userDao;
    }


    @Override
    public Result addVehicle(VehicleSeatDto vehicleSeatDto) {
    //sadece admin kullanır
        if (userDao.getById(vehicleSeatDto.getUserId()).isAdmin()){
            Vehicle vehicle=new Vehicle(
                    vehicleSeatDto.getNumberPlate(),vehicleSeatDto.getDate(),
                    vehicleSeatDto.getCurrentPlace(),vehicleSeatDto.getDestinationPlace());

            this.vehicleDao.save(vehicle);

            long vehicleId = getVehicleIdByNumberPlate(vehicleSeatDto.getNumberPlate());

            addSeatsForVehicle(vehicleSeatDto.getSeatCount(),vehicleId);

            return new SuccessResult("Başarılı");
        }
        else return new ErrorResult(false,"ADMİN DEĞİLSİNİZ!");
    }

    public void addSeatsForVehicle(int seatCount,long vehicleId){

        for(int seatNumber=1;seatNumber<=seatCount;seatNumber++){

            Seat seat=new Seat(vehicleId,seatNumber);

            this.seatDao.save(seat);
        }

    }

    @Override
    public Result updateVehicle(UpdateVehicleDto updateVehicleDto) {
        //sadece admin kullanır
        if (userDao.getById(updateVehicleDto.getUserId()).isAdmin()){

            try{

                Vehicle vehicle=vehicleDao.getById(updateVehicleDto.getVehicleId());
                vehicle.setDate(updateVehicleDto.getDate());
                vehicle.setCurrentPlace(updateVehicleDto.getCurrentPlace());
                vehicle.setDestinationPlace(updateVehicleDto.getDestinationPlace());
                vehicle.setNumberPlate(updateVehicleDto.getNumberPlate());
                vehicleDao.save(vehicle);

                return new SuccessResult("Güncellendi.");

            }
            catch (Exception e){

                return new ErrorResult(false,e.getMessage());

            }

        }
        else return new ErrorResult(false,"ADMİN DEĞİLSİNİZ!");
    }

    @Override
    public long getVehicleIdByNumberPlate(String numberPlate){

        return this.vehicleDao.getVehicleIdByNumberPlate(numberPlate);
    }

    @Override
    public Vehicle getVehicleById(long vehicleId) {

        return this.vehicleDao.getById(vehicleId);
    }

    @Override
    public Result deleteVehicleById(DeleteVehicleDto deleteVehicleDto) {
        //sadece admin kullanır
        if (userDao.getById(deleteVehicleDto.getUserId()).isAdmin()) {
            deleteSeatsForVehicle(deleteVehicleDto.getVehicleId());
            this.vehicleDao.deleteById(deleteVehicleDto.getVehicleId());
            return new SuccessResult("Başarılı");
        }
        else return new ErrorResult(false,"ADMİN DEĞİLSİNİZ!");
    }

    public void deleteSeatsForVehicle(long vehicleId) {

            this.seatDao.deleteAll(getSeatsByVehicleId(vehicleId));
    }

    @Override
    public List<Seat> getSeatsByVehicleId(long vehicleId) {

        return this.seatDao.getSeatsByVehicleId(vehicleId);
    }
    

}
