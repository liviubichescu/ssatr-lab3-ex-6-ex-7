/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatr.ia.ex6.parking;

import java.util.Objects;

/**
 *
 * @author liviu.bichescu
 */
public class Car {
    private String carNumber;
    private double entryTime;

    public Car(String carNumber, double entryTime) {
        this.carNumber = carNumber;
        this.entryTime = entryTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public double getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(double entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (Double.doubleToLongBits(this.entryTime) != Double.doubleToLongBits(other.entryTime)) {
            return false;
        }
        if (!Objects.equals(this.carNumber, other.carNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "carNumber=" + carNumber + ", entryTime=" + entryTime + '}';
    }
    
    
}
