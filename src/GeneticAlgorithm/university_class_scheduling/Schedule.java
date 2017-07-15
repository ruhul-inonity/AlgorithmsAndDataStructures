package GeneticAlgorithm.university_class_scheduling;

import java.util.ArrayList;

/**
 * Created by ruhul on 7/13/17.
 */
public class Schedule {
    private ArrayList<Class> classes;
    private Data data;

    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<>(data.getNumberOfClasses());
    }

    public Data getData() {
        return data;
    }
}
