/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatr.ia.ex6.parking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author liviu.bichescu
 */
public class ParkingRepository {
    
    private ArrayList<Car> cars;

    public ParkingRepository() {
        this.cars = new ArrayList();
        this.initiateRepo();
    }    

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
    
    public void addCar(Car e) {
        this.cars.add(e);
    }
    
    public Car findCar(String carNumber) {
        return this.cars.stream()
                    .filter(c -> c.getCarNumber().equals(carNumber))
                    .findFirst()
                    .orElse(null);           
    }
    
    public void deleteCar(String carNumber) {
        Car car = this.cars.stream()
                    .filter(c -> c.getCarNumber().equals(carNumber))
                    .findFirst()
                    .orElse(null);      
        if (car != null){
            this.cars.remove(car);
        }
    }
    
    public void initiateRepo(){
        var car1 = new Car("CJ 01 TST", System.currentTimeMillis() - 300000); // current time -5 minute
        var car2 = new Car("CJ 02 TST", System.currentTimeMillis() - 60000); // current  -1 minute
        var car3 = new Car("CJ 03 TST", System.currentTimeMillis());
        this.cars.add(car1);
        this.cars.add(car2);
        this.cars.add(car3);
    }
}
