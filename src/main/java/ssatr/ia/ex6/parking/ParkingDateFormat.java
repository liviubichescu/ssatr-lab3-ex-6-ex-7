/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatr.ia.ex6.parking;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author liviu.bichescu
 */
public class ParkingDateFormat {

    public static String getCurrentTimeStamp(long miliseconds) {
        Date now = new Date(miliseconds);
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
