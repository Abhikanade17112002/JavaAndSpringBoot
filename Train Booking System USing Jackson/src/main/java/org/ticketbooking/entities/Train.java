package org.ticketbooking.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainId ;

    private int trainNo ;

    private List<List<Integer>>  seatMatrix ;

    private Map<String , LocalDateTime> stationTimeMappings ;

    private List<String> stations ;

    public Train(int trainNo, List<String> stations, Map<String, LocalDateTime> stationTimeMappings, List<List<Integer>> seatMatrix, String trainId) {
        this.trainNo = trainNo;
        this.stations = stations;
        this.stationTimeMappings = stationTimeMappings;
        this.seatMatrix = seatMatrix;
        this.trainId = trainId;
    }

    public Train() {
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeatMatrix() {
        return seatMatrix;
    }

    public void setSeatMatrix(List<List<Integer>> seatMatrix) {
        this.seatMatrix = seatMatrix;
    }

    public Map<String, LocalDateTime> getStationTimeMappings() {
        return stationTimeMappings;
    }

    public void setStationTimeMappings(Map<String, LocalDateTime> stationTimeMappings) {
        this.stationTimeMappings = stationTimeMappings;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public void printTrainSeatMatrix() {
        List<List<Integer>> matrix = this.getSeatMatrix();
        if (matrix == null || matrix.isEmpty()) {
            System.out.println("No seat matrix available.");
            return;
        }

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        // Print title
        System.out.println("\n=== Train Seat Layout ===\n");

        // Print column headers
        System.out.print("     "); // space for row labels
        for (int c = 1; c <= cols; c++) {
            System.out.printf(" %2d  ", c); // column numbers
        }
        System.out.println();

        // Print top border
        System.out.print("    ");
        for (int c = 0; c < cols; c++) {
            System.out.print("-----");
        }
        System.out.println();

        // Print rows
        for (int r = 0; r < rows; r++) {
            System.out.printf("R%02d |", r + 1); // Row label with leading zero
            for (int c = 0; c < cols; c++) {
                Integer seat = matrix.get(r).get(c);
                String display = (seat == 1) ? " O " : " X "; // O = Available, X = Booked
                System.out.printf(" %s ", display);
            }
            System.out.println();
        }

        // Legend
        System.out.println("\n O = Available   X = Booked\n");
    }


    public void printTrainStationTimings(){

        for( String station : this.getStationTimeMappings().keySet() ){
            System.out.println("Station ==> " + station + " Time ==> " + this.stationTimeMappings.get(station).toString().split("T")[1] );
            System.out.println();
        }
    }

    public void printTrainInfo() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("\n================ TRAIN INFORMATION ================");
        System.out.println("Train ID   : " + this.getTrainId());
        System.out.println("Train No   : " + this.getTrainNo());
        System.out.println("Route      : " + String.join(" → ", this.getStations()));
        System.out.println("---------------------------------------------------");
        System.out.println("Station Timings:");

        // Sort by time for better readability
        this.getStationTimeMappings().entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(entry -> {
                    String formattedTime = entry.getValue().format(dateTimeFormatter);
                    System.out.printf("  %-20s : %s%n", entry.getKey(), formattedTime);
                });

        // Show seat layout
        printTrainSeatMatrix();

        System.out.println("===================================================\n");
    }
}
