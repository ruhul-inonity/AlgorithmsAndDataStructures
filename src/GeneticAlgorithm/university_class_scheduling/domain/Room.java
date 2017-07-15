package GeneticAlgorithm.university_class_scheduling.domain;

/**
 * Created by ruhul on 7/15/17.
 */
public class Room {
    private String number;
    private int seatingCapacity;

    public Room(String number, int seatingCapacity) {
        this.number = number;
        this.seatingCapacity = seatingCapacity;
    }

    public String getNumber() {
        return number;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
