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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author liviu.bichescu
 */
public class ParkingClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");

        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti numarul de inmatriculare: ");
        
        String input = in.nextLine();
        
        fluxOut.println(input);
        String response = fluxIn.readLine();
        System.out.println(response);
                
        fluxOut.println("close connection");
     
        s.close();
    }
}
