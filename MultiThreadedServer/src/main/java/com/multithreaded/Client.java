package com.multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public Runnable getRunnableClient() throws UnknownHostException {
        final int portNumber = 8010 ;
        final InetAddress serverAddress = InetAddress.getLocalHost() ;

        Runnable newRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Socket newClient = new Socket(serverAddress,portNumber) ;

                    PrintWriter toServer = new PrintWriter( newClient.getOutputStream() ) ;
                    BufferedReader fromServer = new BufferedReader( new InputStreamReader( newClient.getInputStream() )) ;

                    System.out.println("Recived Message From Server ==> " + fromServer.readLine() + " Client Thread ==> "+ Thread.currentThread().getName());
                    System.out.println("Sending Message To The Server Using Client Thread  ==> " + Thread.currentThread().getName());
                    toServer.println("Message From Client Using Thread ==> " + Thread.currentThread().getName() + " To Server ");
                    toServer.flush();

                    toServer.close();
                    fromServer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } ;


        return newRunnable ;

    }
    public static void main(String[] args) {

        System.out.println("Welcome To Clients ");

        try {

            for( int i =1 ; i <= 5 ; i++ ){

                Client newClient = new Client() ;

                Thread clientThread = new Thread( newClient.getRunnableClient() ) ;
                clientThread.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
