package GeneticAlgorithm.university_class_scheduling.domain;

import java.util.ArrayList;

/**
 * Created by ruhul on 7/15/17.
 */
public class Department {
    private String name;
    private ArrayList<Course> courses;

    public Department(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
