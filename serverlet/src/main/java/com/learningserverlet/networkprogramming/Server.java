package com.learningserverlet.networkprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final int portNumber = 8080 ;

    public void run(){
        ServerSocket serverSocket = null ;

        try{

            serverSocket = new ServerSocket(portNumber) ;
            Socket connectedClientSocket = serverSocket.accept() ;
            System.out.println("Connected To The Socket ==> " + connectedClientSocket.getInetAddress());

            PrintWriter toClient = new PrintWriter( connectedClientSocket.getOutputStream()) ;
            BufferedReader fromClient = new BufferedReader( new InputStreamReader( connectedClientSocket.getInputStream())) ;

            toClient.println("Welcome To The Server Client ==> " + connectedClientSocket.getInetAddress());
            toClient.flush();
            System.out.println("From Client ==> " + fromClient.readLine());

            System.out.println("Closing On Server Side");

            toClient.close();
            fromClient.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage() + " Error In Server Socket ");
        }

    }

    public static void main(String[] args) {
        Server server = new Server() ;

        server.run();
    }
}
