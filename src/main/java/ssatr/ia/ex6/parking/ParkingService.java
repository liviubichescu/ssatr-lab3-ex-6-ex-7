/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatr.ia.ex6.parking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author liviu.bichescu
 */
public class ParkingService {

    private ParkingRepository repo;

    public ParkingService() {
        this.repo = new ParkingRepository();
    }

    public String checkForCars(String carNumber) {
        Car car = repo.findCar(carNumber);
        if (car == null) {
            long entryTimeMillis = System.currentTimeMillis();

            Car newCar = new Car(carNumber, entryTimeMillis);
            repo.addCar(newCar);
            return "Intrare auto: " + newCar.getCarNumber() + ". Data: " + ParkingDateFormat.getCurrentTimeStamp(entryTimeMillis) + ".";
        } else {
            long exitTimeMillis = System.currentTimeMillis();

            var stayPrice = (((exitTimeMillis - car.getEntryTime()) / 1000) * 1);
            repo.deleteCar(car.getCarNumber());

            return "Iesire auto: " + car.getCarNumber() + ". Data: " + ParkingDateFormat.getCurrentTimeStamp(exitTimeMillis) + "."
                    + " Cost utilizator: " + stayPrice + " RON";
        }
    }

    public String getParkingCars() {
        var carList = this.repo.getCars();
        
        var rsp = "";
        
        for (Car car : carList) {
            rsp = rsp + car.getCarNumber() + " - Data intrarii: " + ParkingDateFormat.getCurrentTimeStamp((long)car.getEntryTime()) + "/n";
        }
        return rsp;
    }
   
}
