package com.multithreaded;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

    public Runnable getRunnable( Socket client ){

        Runnable newRunnable = new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("Client ==> " + client.getInetAddress() + " Connected Succesfully " + Thread.currentThread().getName() );
                    PrintWriter toClient = new PrintWriter( client.getOutputStream() ) ;
                    BufferedReader fromClient = new BufferedReader( new InputStreamReader( client.getInputStream() ) ) ;

                    System.out.println("Sending Message From Server Using Thread ==> " + Thread.currentThread().getName() + " To Client ==> " + client.getInetAddress());
                    toClient.println(" Message From Server To Client ==> " + Thread.currentThread().getName() );
                    toClient.flush();
                    System.out.println(" Recived Message From Client To Server ==> " + fromClient.readLine() + " Thread ==> " + Thread.currentThread().getName()) ;

                    toClient.close();
                    fromClient.close();
                    client.close();



                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }


            }
        } ;


        return newRunnable ;

    }
    public void runServer() throws IOException {
        final int portNumber =8010 ;

        ServerSocket serverSocket = new ServerSocket(portNumber) ;

        while( true ){
            System.out.println("Server Is Listening And Waiting For A Client To Connect .");
            Socket acceptedConnection = serverSocket.accept() ;

            Thread thread = new Thread( getRunnable( acceptedConnection )) ;

            thread.start();

        }


    }
    public static void main( String[] args )
    {

        System.out.println("Welcome To Server ==> ");

        try{
            Server server = new Server() ;
            server.runServer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}