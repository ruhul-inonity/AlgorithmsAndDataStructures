package GeneticAlgorithm.university_class_scheduling;

import GeneticAlgorithm.university_class_scheduling.domain.Department;
import GeneticAlgorithm.university_class_scheduling.domain.Class;
import java.util.ArrayList;

/**
 * Created by ruhul on 7/13/17.
 */
public class Schedule {
    private ArrayList<Class> classes;
    private Data data;
    private int classNumb = 0;
    private int numbOfConflics = 0;
    private double fitness = 0;
    private boolean isFitnessChanged = true;

    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<>(data.getNumberOfClasses());
    }

    public Data getData() {
        return data;
    }

    public Schedule initialize(){
        new ArrayList<Department>(data.getDepts()).forEach(dept -> {
            dept.getCourses().forEach(course -> {
                Class newClass = new Class(classNumb++, dept, course);
                newClass.setMeetingTime(data.getMeetingTimes()
                        .get((int)(data.getMeetingTimes().size() * Math.random())));
                newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
                newClass.setInstructor(course.getInstructors().get((int) (course.getInstructors().size() * Math.random())));
                classes.add(newClass);
            });
        });
        return this;
    }

    public ArrayList<Class> getClasses(){
        isFitnessChanged = true;
        return classes;
    }

    public int getNumbOfConflics() {
        return numbOfConflics;
    }

    public double getFitness(){
        if (isFitnessChanged == true){
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    //go through all the classes and check room capacity and meeting time and finally find conflicts
    private double calculateFitness() {
        numbOfConflics = 0;
        classes.forEach(x -> {
            if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents()) numbOfConflics++;
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()){
                    if (x.getRoom() == y.getRoom()) numbOfConflics++;
                    if (x.getInstructor() == y.getInstructor()) numbOfConflics++;
                }
            });
        });
        return 1/(double)(numbOfConflics+1);
    }

    //return all the classes and separate by comma
    public String toString(){
        String returnValue = "";
        for (int x = 0; x < classes.size()-1; x++) {
            returnValue += classes.get(x)+ ",";
        }
        returnValue += classes.get(classes.size()-1);
        return returnValue;
    }
}
