package GeneticAlgorithm.university_class_scheduling.domain;

import java.util.ArrayList;

/**
 * Created by ruhul on 7/15/17.
 */
public class Course {
    private String number = null;
    private String name = null;
    private int maxNumberOfStudents;
    private ArrayList<Instructor> instructors;

    public Course(String number, String name, ArrayList<Instructor> instructors ,int maxNumberOfStudents) {
        this.number = number;
        this.name = name;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.instructors = instructors;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
}
