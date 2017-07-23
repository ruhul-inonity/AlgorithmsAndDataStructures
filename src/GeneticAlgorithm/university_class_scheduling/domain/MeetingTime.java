package GeneticAlgorithm.university_class_scheduling.domain;

/**
 * Created by ruhul on 7/15/17.
 */
public class MeetingTime {
    private String id;
    private String time;

    public MeetingTime(String id, String time) {
        this.id = id;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }
}
