package org.ticketbooking.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    private String firstName ;

    private String lastName ;

    private String userName ;

    private String hashedPassword ;

    @JsonManagedReference
    private List<Ticket> userBookedTickets ;

    private String userId  ;

    public User() {
    }
    public User(String firstName ,String lastName ,  String userName ,String userId, String hashedPassword, List<Ticket> userBookedTickets ) {
        this.firstName = firstName;
        this.userId = userId;
        this.hashedPassword = hashedPassword;
        this.userBookedTickets = userBookedTickets;
        this.userName = userName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Ticket> getUserBookedTickets() {
        return userBookedTickets;
    }

    public void setUserBookedTickets(List<Ticket> userBookedTickets) {
        this.userBookedTickets = userBookedTickets;
    }
    public void getUserInfo(){
        System.out.println();
        System.out.println("User Id ==> " + getUserId() + " Username ==> " + getUserName() + " User Full Name ==> " + getFullName()  );
        getUserTicketsInfo();
        System.out.println();
    }

    public void getUserTicketsInfo(){

        for( Ticket ticket : this.userBookedTickets ){
                ticket.getTicketInfo();
        }

    }
}
