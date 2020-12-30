/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatr.ia.ex6.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author liviu.bichescu
 */
public class ParkingServer {

    public static void main(String[] args) throws IOException {

        ParkingService parkingService = new ParkingService();

        ServerSocket ss = new ServerSocket(4050);

        while (true) {
            System.out.println("Astept conexiune de la client...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Clientul s-a conectat!");

            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);

            String line = "";
            while (!line.equals("close connection")) {
                line = fluxIn.readLine();
                System.out.println("Am primti de la client: " + line);
                if (!line.equals("close connection") && !line.equals("getParkingCars")) {
                    String result = parkingService.checkForCars(line);
                    fluxOut.println(result);
                }
                if (line.equals("getParkingCars")) {
                    String result = parkingService.getParkingCars();
                    fluxOut.println(result);
                }
            }

            s.close();
        }
    }

}
