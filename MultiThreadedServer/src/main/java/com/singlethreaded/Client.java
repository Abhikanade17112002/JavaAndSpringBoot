package com.singlethreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void run() throws UnknownHostException {
        final int serverPort = 8010 ;
        final InetAddress serverAddress = InetAddress.getLocalHost() ;

        try{
            Socket clientSocket = new Socket(serverAddress,serverPort) ;
            PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream()) ;
            BufferedReader fromServer = new BufferedReader( new InputStreamReader( clientSocket.getInputStream())) ;

            System.out.println(" Message From The Server To The Client ==> " + fromServer.readLine());
            System.out.println("Sending Message To Server ");
            toServer.println("Hello From Client ");
            toServer.flush();

            toServer.close();
            fromServer.close();
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(" ERROR " + e.getMessage());


        }
    }
    public static void main(String[] args) {

        try{
            Client client = new Client() ;
            client.run();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
