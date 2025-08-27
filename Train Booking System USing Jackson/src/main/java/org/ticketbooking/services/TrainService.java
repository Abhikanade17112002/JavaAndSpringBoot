package org.ticketbooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.ticketbooking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainService {

    private List<Train> trainList;
    private ObjectMapper objMapper;

    private final String trainFilePath = "src/main/java/org/ticketbooking/localdatabase/Trains.json";

    public TrainService() throws IOException {
        objMapper = new ObjectMapper();
        objMapper.registerModule(new JavaTimeModule()); // Support LocalDate/LocalDateTime
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        File trainFile = new File(trainFilePath);
        this.trainList = objMapper.readValue(trainFile, new TypeReference<List<Train>>() {});
    }
    public Train getTrainFromTrainNo( int trainNo ){
        Optional<Train> filteredTrain = this.trainList
                .stream()
                .filter((train)->{
                    return ( train.getTrainNo() == trainNo ) ;
                }).findFirst() ;

        return filteredTrain.get() ;
    }
    public List<Train> searchTrainsBetweenStations(String startStation, String endStation) {
        String startLower = startStation.toLowerCase().trim();
        String endLower = endStation.toLowerCase().trim();

        return this.trainList.stream()
                .filter(train -> {
                    List<String> stationsLower = train.getStations().stream()
                            .map(s -> s.toLowerCase().trim())
                            .collect(Collectors.toList());

                    // Find first station that contains startLower
                    int startIndex = -1;
                    int endIndex = -1;

                    for (int i = 0; i < stationsLower.size(); i++) {
                        if (stationsLower.get(i).contains(startLower) && startIndex == -1) {
                            startIndex = i;
                        }
                        if (stationsLower.get(i).contains(endLower)) {
                            endIndex = i;
                        }
                    }

                    return startIndex != -1 && endIndex != -1 && startIndex < endIndex;
                })
                .collect(Collectors.toList());
    }


    public boolean checkSeatAvailability( String trainId , int rowNumber , int columnNumber  ){


        Optional<Train> retrivedTrain = this.trainList
                .stream()
                .filter((currTrain)->{
                    return currTrain.getTrainId().equalsIgnoreCase(trainId) ;
                }).findFirst() ;


        if( retrivedTrain.isPresent() ){
            Train train = retrivedTrain.get() ;
            List<List<Integer>> seatMatrix = train.getSeatMatrix() ;

          int seat = seatMatrix.get(rowNumber).get(columnNumber ) ;

          if( seat == 1 ){
              return true ;
          }
          else{
              return false ;
          }
        }


        System.out.println("No Train With Id ==> " + trainId + " Found ");

        return false ;

    }

    public List<List<Integer>> updateTrainSeatMatrix( List<List<Integer>> seatMatrix , int rowNumber , int columnNumber, boolean type ){

        System.out.println();
        if( type == true ){
            seatMatrix.get(rowNumber).set(columnNumber , 0 ) ;

        }
        else{
            seatMatrix.get(rowNumber).set(columnNumber , 1 ) ;

        }

        return seatMatrix ;

    }

    public void saveUpdatedTrainList() throws  IOException {

        File trainFile = new File(this.trainFilePath) ;
        this.objMapper.writeValue(trainFile,this.trainList);

    }

    public void bookTrainTicket( String trainId , int rowNumber, int colNumber  ) throws IOException {

        for (Train currTrain : trainList) {
            if (currTrain.getTrainId().equalsIgnoreCase(trainId)) {
                currTrain.setSeatMatrix(updateTrainSeatMatrix(
                                currTrain.getSeatMatrix(),
                                rowNumber,
                                colNumber,
                                true // booking means setting to 0 (available -> booked)
                        )
                );
                break; // stop once we found and updated the train
            }
        }
        saveUpdatedTrainList();
    }




}
