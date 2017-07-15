package GeneticAlgorithm.university_class_scheduling.domain;

/**
 * Created by ruhul on 7/15/17.
 */
public class MeetingTime {
    private String id;
    private String name;

    public MeetingTime(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
