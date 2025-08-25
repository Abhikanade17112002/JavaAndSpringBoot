package org.ticketbooking.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticketbooking.entities.User;
import org.ticketbooking.utility.PasswordUtility;
import org.ticketbooking.entities.Ticket ;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UserBookingService {

    private User user ;

    private List<User> usersList ;

    private final String usersFilePath = "src/main/java/org/ticketbooking/localdatabase/Users.json" ;


    private static ObjectMapper objMapper = new ObjectMapper() ;

    public UserBookingService( ) throws  IOException {
        objMapper = new ObjectMapper();
        objMapper.registerModule(new JavaTimeModule()); // Support LocalDate/LocalDateTime
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file = new File(this.usersFilePath) ;
        this.usersList = objMapper.readValue(file, new TypeReference<List<User>>() {
        }) ;
    }

    public void saveUserToList() throws IOException {
        File userFile = new File(this.usersFilePath) ;
        objMapper.writeValue(userFile,this.usersList);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public boolean signUpUser(User newUser ){

        try{
            this.usersList.add(newUser) ;
            saveUserToList();
            setUser(newUser);
            return true ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public User logInUser( String userName , String password ){


        Optional<User> filtertedUser = this.usersList
                                      .stream()
                                      .filter((currUser)->{
                                          return ( currUser.getUserName().equalsIgnoreCase(userName)) && ( PasswordUtility.comparePassword(password,currUser.getHashedPassword())) ;
                                      }).findFirst() ;

        if( filtertedUser.isPresent() ){
            return filtertedUser.get() ;
        }
        else {
            return null ;
        }


    }

    public void updateUserTickets( User user , Ticket newTicket ) throws IOException {

        this.usersList = this.usersList
                .stream()
                .map((currUser)->{
                    if( currUser.getUserId().equalsIgnoreCase(user.getUserId()) ){

                        currUser.getUserBookedTickets().add(newTicket) ;

                        return currUser ;
                    }
                    else {
                        return currUser ;
                    }
                }).collect(Collectors.toList());

        saveUserToList();

    }

    public boolean logOutUser(){
        setUser(null);
        return true ;
    }


    public List<User> getUsersList(){
        return this.usersList ;
    }




}
