package com.singlethreaded;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public void run(){
        final int portNumber = 8010 ;

        try{
            ServerSocket serverSocket = new ServerSocket(portNumber) ;

            while( true ){
                System.out.println("Server Waiting For Client To Connect On Port ==> " + portNumber);
                Socket acceptedConnection = serverSocket.accept();

                System.out.println("Client Connected ==> " + acceptedConnection.getInetAddress() );


                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream()) ;
                BufferedReader fromClient = new BufferedReader( new InputStreamReader( acceptedConnection.getInputStream() ) ) ;

                System.out.println("Sending The Message To The Client ");
                toClient.println("Hello From The Server Client ==> "+ acceptedConnection.getInetAddress() );
                toClient.flush();
                System.out.println("Recived Message From The Client ");
                System.out.println(fromClient.readLine());

                System.out.println("Closing ");
                toClient.close();
                acceptedConnection.close();

            }


        } catch (Exception e) {
            System.out.println("Error :: " + e.getMessage() );
        }
    }
    public static void main(String[] args) {

        try {
            Server server = new Server();
            server.run();
        } catch (Exception e) {
            System.out.println(" ERROR " + e.getMessage() );
        }

    }
}
