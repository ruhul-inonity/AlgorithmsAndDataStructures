package GeneticAlgorithm.university_class_scheduling;

import GeneticAlgorithm.fitness_finder.GeneticAlgo;
import GeneticAlgorithm.university_class_scheduling.domain.Class;

import java.util.ArrayList;

/**
 * Created by ruhul on 7/13/17.
 */
public class Driver_schedule {
    public static final int POPULATION_SIZE = 9;
    public static final double MUTANT_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumb = 0;
    private int classNumb = 1;
    private Data data;

    public static void main(String[] args) {
        Driver_schedule driver = new Driver_schedule();
        driver.data = new Data();
        int generationNumber = 0;
        driver.printAvailableData();
        System.out.println("> Generation # " + generationNumber);
        System.out.println("  Schedule # |                                      ");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\tClasses [dept,class,room,instructor,meeting-time]        ");
        System.out.println("                           |Fitness  | Conflicts");
        System.out.print("\t\t\t----------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        GeneticAlgor geneticAlgor = new GeneticAlgor(driver.data);
        Population population = new Population(Driver_schedule.POPULATION_SIZE, driver.data).shortByFitness();
        population.getSchedules().forEach(schedule ->
                System.out.println("        " + driver.scheduleNumb++ +
                        "   | " + schedule + "    | " +
                        String.format("%.5f", schedule.getFitness()) +
                        "   | " + schedule.getNumbOfConflics()));
        driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
        driver.classNumb = 1;
        while (population.getSchedules().get(0).getFitness() != 1.0){
            System.out.println("> Generation : "+ ++generationNumber);
            System.out.print("    Schedule # |\t\t\t\t\t\t\t\t\t\t");
            System.out.print("Classes [dept,class,room,instructor,meeting-time]           ");
            System.out.println("                                    | Fitness | Conflicts");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            population = geneticAlgor.evolve(population).shortByFitness();
            driver.scheduleNumb = 0;
            population.getSchedules().forEach(schedule -> System.out.println("      "+driver.scheduleNumb++ +
                                                            "       | "+schedule + " | "+
                                                            String.format("%.5f",schedule.getFitness())+
                                                            " | "+schedule.getNumbOfConflics()));
            driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
            driver.classNumb = 1;
        }
    }

    private void printAvailableData() {
        System.out.println("Available Departments ==>");
        data.getDepts().forEach(x -> System.out.println("name " + x.getName() + ", courses: " + x.getCourses()));
        System.out.println("\n Available Courses ==>");
        data.getCourses().forEach(x -> System.out.println("course #: " + x.getNumber() + ", name " + x.getName()
                + " max # of students: " + x.getMaxNumberOfStudents() + " instructors " + x.getInstructors()));
        System.out.println("Available Rooms ==> ");
        data.getRooms().forEach(x -> System.out.println("room #: " + x.getNumber() + ", max seating capacity " + x.getSeatingCapacity()));
        System.out.println("Available Instructors ==> ");
        data.getInstructors().forEach(x -> System.out.println("id: " + x.getId() + " name: " + x.getName()));
        System.out.println("\nAvailable Meeting Times ==> ");
        data.getMeetingTimes().forEach(x -> System.out.println("id: " + x.getId() + ", Meeting Time: " + x.getTime()));
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------");


    }
    private void printScheduleAsTable(Schedule schedule , int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.println("\n\t\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t\tClass # | Dept    | Course (number, max # of students) |  Room(Capacity) |    Instructor (id) |   Meeting time (id)");
        System.out.println("\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t\t------------------------------------------------------------------------------------------------------------------------------------------");
        classes.forEach(x -> {
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int courseIndex = data.getCourses().indexOf(x.getCourse());
            int roomsIndex = data.getRooms().indexOf(x.getRoom());
            int instructorIndex = data.getInstructors().indexOf(x.getInstructor());
            int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("\t\t\t\t\t\t\t");
            System.out.print(String.format("  %1$02d  ",classNumb)+ " | ");
            System.out.print(String.format("  %1$4s  ",data.getDepts().get(majorIndex).getName())+ "  | ");
            System.out.print(String.format("  %1$21s  ",data.getCourses().get(courseIndex).getName()
                                            + " (" + data.getCourses().get(courseIndex).getNumber()
                                            + ","+ x.getCourse().getMaxNumberOfStudents())+ ")  | ");
            System.out.print(String.format("  %1$10s  ",data.getRooms().get(roomsIndex).getNumber()
                                            + ","+ x.getRoom().getSeatingCapacity())+ ")    | ");
            System.out.print(String.format("  %1$15s  ",data.getInstructors().get(instructorIndex).getName()
                    + ",( "+ data.getInstructors().get(instructorIndex).getId())+")  |    ");
            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime()+
                        "("+data.getMeetingTimes().get(meetingTimeIndex).getId()+")");
            classNumb++;
        });
        if (schedule.getFitness() == 1 ) System.out.println("> solution found in "+ (generation + 1)+" generations");
        System.out.println("\t\t\t\t\t\t\t----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
