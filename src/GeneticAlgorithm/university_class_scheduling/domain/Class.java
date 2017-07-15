package GeneticAlgorithm.university_class_scheduling.domain;

/**
 * Created by ruhul on 7/15/17.
 */
public class Class {
    private int id;
    private Department dept;
    private Course course;
    private Instructor instructor;
    private MeetingTime meetingTime;
    private Room room;

    public Class(int id, Department dept, Course course) {
        this.id = id;
        this.dept = dept;
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public Department getDept() {
        return dept;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    public Room getRoom() {
        return room;
    }
    public String toString(){
        return "["+dept.getName()+","+course.getNumber()+","+instructor.getId()+","+meetingTime.getId()+"]" ;
    }
}
