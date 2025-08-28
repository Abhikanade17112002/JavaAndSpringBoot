package com.learningserverlet.networkprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public final InetAddress remoteServerAddress = InetAddress.getLocalHost() ;
    public final int remoteServerPort = 8080 ;

    public Client() throws UnknownHostException {
    }


    public void run(){

        try{
          Socket  clientSocket = new Socket(remoteServerAddress,remoteServerPort) ;

            PrintWriter toServer = new PrintWriter( clientSocket.getOutputStream() ) ;
            BufferedReader fromServer = new BufferedReader( new InputStreamReader( clientSocket.getInputStream())) ;

            System.out.println("From Server ==> " + fromServer.readLine());
            toServer.println("I Am A Client");
            toServer.flush(); ;

            System.out.println("Closing On Clinet End ");
            toServer.close();
            fromServer.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Errror On Client Side ==> " + e.getMessage() );
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        Client client = new Client() ;

        client.run();
    }
}
