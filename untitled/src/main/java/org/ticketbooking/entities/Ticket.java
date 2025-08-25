package org.ticketbooking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId ;

    private String seatNumber ;
    @JsonBackReference
    private User belongsToUser ;

    private String boardingStation ;

    private String destinationStation ;

    private LocalDateTime travelDateTime ;

    private Train boardingTrain ;

    public Ticket() {
    }

    public Ticket(String ticketId , String seatNumber , User belongsToUser, String boardingStation, String destinationStation, LocalDateTime travelDateTime, Train boardingTrain) {
        this.ticketId = ticketId;
        this.belongsToUser = belongsToUser;
        this.boardingStation = boardingStation;
        this.destinationStation = destinationStation;
        this.travelDateTime = travelDateTime;
        this.boardingTrain = boardingTrain;
        this.seatNumber = seatNumber ;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public User getBelongsToUser() {
        return belongsToUser;
    }

    public void setBelongsToUser(User belongsToUser) {
        this.belongsToUser = belongsToUser;
    }

    public String getBoardingStation() {
        return boardingStation;
    }

    public void setBoardingStation(String boardingStation) {
        this.boardingStation = boardingStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public LocalDateTime getTravelDateTime() {
        return travelDateTime;
    }

    public void setTravelDateTime(LocalDateTime travelDateTime) {
        this.travelDateTime = travelDateTime;
    }

    public Train getBoardingTrain() {
        return boardingTrain;
    }

    public void setBoardingTrain(Train boardingTrain) {
        this.boardingTrain = boardingTrain;
    }

    public void getTicketInfo(){
        System.out.println();
        System.out.println("******************************************************************");
        System.out.println("Ticket Id ==>"+ this.getTicketId() + " Seat Number ==> "+ this.seatNumber + ". Belongs to user ==> "+this.belongsToUser.getFirstName()+ " " + this.belongsToUser.getLastName());
        System.out.println("Boarding Station ==> " + this.getBoardingStation());
        System.out.println("Destination Station ==> "+ this.getDestinationStation());
        System.out.println("Travel Date Time ==> "+ this.getTravelDateTime());
        System.out.println("******************************************************************");
        System.out.println();
    }


}
