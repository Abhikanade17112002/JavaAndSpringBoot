package org.ticketbooking;

import org.ticketbooking.entities.Ticket;
import org.ticketbooking.entities.Train;
import org.ticketbooking.entities.User;
import org.ticketbooking.services.TicketService;
import org.ticketbooking.services.TrainService;
import org.ticketbooking.services.UserBookingService;
import org.ticketbooking.utility.PasswordUtility;
import java.util.*;

public class Main
{
    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in) ;

        try{
            UserBookingService userBookingService = new UserBookingService() ;
            TrainService trainService = new TrainService() ;
            TicketService ticketService = new TicketService() ;
            while( true ){
                System.out.println();
                System.out.println();
                System.out.println("******************** Welcome To CLI Based IRCTC Ticket Booking System **********************");
                System.out.println();
                System.out.println();

                System.out.println("Choose The Option To Perform The Action ");

                System.out.println();
                System.out.println();

                System.out.println("1. Signup User");
                System.out.println("2. LogIn User ");
                System.out.println("3. LogOut User ");
                System.out.println("4. Search Trains Between Stations ");
                System.out.println("5. Book Ticket ");
                System.out.println("0. Exit System ");
                int choice = scan.nextInt();
                scan.nextLine() ;
                switch( choice ){
                    case 1 :
                        Optional<User> user = Optional.ofNullable(userBookingService.getUser());

                        if( user.isPresent() ){
                            System.out.println("User ==> " + user.get().getFullName() + " Already Logged In , Please Log Out To Create New User");
                        }
                        else{

                            System.out.printf("Enter User First Name ==> ");
                            String firstName = scan.nextLine() ;
                            System.out.printf("Enter User Last Name ==> ");
                            String lastName = scan.nextLine() ;
                            System.out.printf("Enter User Password ==> ");
                            String userPassword = scan.nextLine() ;
                            int randomNum = (int)(Math.random() * 1000);
                            String userName =  firstName.trim() + lastName.trim() + randomNum;
                            String userId = String.valueOf(randomNum);
                            User newUser = new User(firstName,lastName,userName,userId, PasswordUtility.getHashedPassword(userPassword),new ArrayList<>()) ;

                            newUser.getUserInfo();
                            if( userBookingService.signUpUser(newUser) ){
                                System.out.println("User Signup Succesfull");
                            }
                            else {
                                System.out.println("Something Went Wrong While User Sign Up");
                            }

                        }
                        break ;

                    case 2 :
                        user = Optional.ofNullable(userBookingService.getUser());
                        if( user.isPresent() ){
                            System.out.println("User ==> " + user.get().getFullName() + " Already Logged In , Please Log Out To Create New User");
                        }
                        else{

                            System.out.printf("Enter Username ==> ");
                            String userName = scan.nextLine() ;
                            System.out.printf("Enter User Password ==> ");
                            String userPassword = scan.nextLine() ;
                            user = Optional.ofNullable(userBookingService.logInUser(userName,userPassword)) ;

                            if( user.isPresent() ){

                                userBookingService.setUser(user.get());
                            }
                            else {
                                System.out.println("User LogIn Failed");
                            }
                        }
                        break ;

                    case 3 :
                        user = Optional.ofNullable(userBookingService.getUser());
                        if( user.isPresent() ){
                            User currUser = userBookingService.getUser() ;
                            userBookingService.setUser(null);
                            System.out.println( currUser.getFullName() +" ==> Logged Out  Succesfully");
                        }
                        else {
                            System.out.println("No User Currently Logged In ");
                        }

                        break ;

                    case 4:
                        System.out.print("Enter Start Station == > ");
                        String startStation = scan.nextLine() ;
                        System.out.print("Enter End Station == > ");
                        String endStation = scan.nextLine() ;
                        System.out.println("The Trains Between The Route " + startStation + " ==> " + endStation );
                        List<Train> trains = trainService.searchTrainsBetweenStations(startStation, endStation);

                        if (trains.isEmpty()) {
                            System.out.println("No trains found between " + startStation + " and " + endStation);
                        } else {
                            System.out.println("\n=== Trains from " + startStation + " to " + endStation + " ===\n");

                            for (Train train : trains) {
                                System.out.println("Train ID: " + train.getTrainId());
                                System.out.println("Train No: " + train.getTrainNo());
                                System.out.println("Route: " + String.join(" → ", train.getStations()));

                                // Find actual station names from train's data (case-insensitive, partial match)
                                String actualStart = train.getStations().stream()
                                        .filter(s -> s.toLowerCase().contains(startStation.toLowerCase()))
                                        .findFirst()
                                        .orElse(startStation);

                                String actualEnd = train.getStations().stream()
                                        .filter(s -> s.toLowerCase().contains(endStation.toLowerCase()))
                                        .findFirst()
                                        .orElse(endStation);

                                // Fetch departure and arrival times
                                String departureTime = train.getStationTimeMappings().get(actualStart).toLocalTime().toString();
                                String arrivalTime = train.getStationTimeMappings().get(actualEnd).toLocalTime().toString();

                                System.out.println("Departure: " + departureTime);
                                System.out.println("Arrival: " + arrivalTime);
                                System.out.println("---------------------------------------------");
                            }

                        }

                        break ;

                    case 5 :

                        if( userBookingService.getUser() != null ){

                            System.out.print("Enter Train No To Book Ticket In ==> ");
                            int trainNo = scan.nextInt() ;
                            scan.nextLine() ;

                            Optional<Train> retrivedTrain = Optional.ofNullable(trainService.getTrainFromTrainNo(trainNo));
                            if( retrivedTrain.isPresent()){
                                Train train = retrivedTrain.get();
                                train.printTrainInfo();

                                System.out.print("Enter the Start station ==> ");
                                startStation = scan.nextLine() ;
                                System.out.print("Enter the End station ==> ");
                                endStation = scan.nextLine() ;

                                System.out.println("Enter The Row No And Column No To Book Seat Using Seat Matrix ");
                                System.out.print("Enter Row Number ==> ");
                                String rowNumber = scan.nextLine() ;
                                System.out.print("Enter Column Number ==> ");
                                String columnNumber = scan.nextLine() ;

                                System.out.println("Checking The Availability Of Seat ==> " + "R"+rowNumber+"C"+columnNumber + " In Train " + train.getTrainId());
                                if( trainService.checkSeatAvailability(train.getTrainId() , Integer.valueOf(rowNumber)  - 1 ,Integer.valueOf(columnNumber) - 1  )){
                                    System.out.println("Seat ==> "  + "R"+rowNumber+"C"+columnNumber + " Available");
                                    System.out.println("Booking Seat.......");
                                    int randomNum = (int)(Math.random() * 1000);
                                    String ticketId = String.valueOf(randomNum);

                                    Ticket newTicket = new Ticket(ticketId,"R"+rowNumber+"C"+columnNumber ,userBookingService.getUser() , startStation , endStation , train.getStationTimeMappings().get(startStation) ,train ) ;
                                    newTicket.getTicketInfo();
                                    trainService.bookTrainTicket(train.getTrainId(),Integer.valueOf(rowNumber)  - 1 ,Integer.valueOf(columnNumber) - 1);
                                    ticketService.createUserTicket(newTicket);
                                    userBookingService.updateUserTickets(userBookingService.getUser(),newTicket);
                                }
                                else {
                                    System.out.println("Seat ==> "  + "R"+rowNumber+"C"+columnNumber + " UnAvailable");
                                }

                        }
                            else {
                                System.out.println("Train With Train No ==> " + trainNo + " Does Not Exists");
                            }





                        }
                        else {
                            System.out.println("User Is Not Loged In ..... Please Logg In ");
                        }

                        break ;
                    case 0: System.exit(0);
                        break ;
                    default:
                        System.out.println("Invalid Choice Made Try Again ");

                }


            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }





    }
}
