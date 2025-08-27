package org.ticketbooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticketbooking.entities.Ticket;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.ticketbooking.entities.Train;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TicketService {

    private List<Ticket> ticketList ;

    private final String ticketFilePath = "src/main/java/org/ticketbooking/localdatabase/Ticket.json" ;

    private ObjectMapper objectMapper = new ObjectMapper() ;

    public TicketService() throws IOException {
        objectMapper.registerModule(new JavaTimeModule()); // Support LocalDate/LocalDateTime
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File trainFile = new File(this.ticketFilePath) ;
        ticketList = objectMapper.readValue(trainFile, new TypeReference<List<Ticket>>() {
        }) ;
    }

    public void updateTicketList() throws IOException {
        File ticketFile = new File(this.ticketFilePath ) ;
        objectMapper.writeValue(ticketFile,this.ticketList);
    }

    public void createUserTicket( Ticket ticket ) throws IOException {
        this.ticketList.add(ticket);
        updateTicketList();
    }



}
