import java.util.HashMap;

public class Course {
    private String courseNumber;
    private String courseTitle;
    private String courseCapacity;
    private String classLocation;
    private int numberOfEnrolledInCourse = 0;
    private static double scores = 0.00;

    private HashMap<Student, Double> courseScores = new HashMap<>();
    private HashMap<Course, Integer> totalEnrolledInCourses = new HashMap<>();

    public Course(String courseNumber, String courseTitle, String courseCapacity, String classLocation) {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseCapacity = courseCapacity;
        this.classLocation = classLocation;
    }

    public void updateLocation(String location) {
        this.setClassLocation(location);
        System.out.println(this.getClassLocation());
    }

    public int getNumberOfEnrolledInCourse() {
        return numberOfEnrolledInCourse;
    }

    public void setNumberOfEnrolledInCourse(int numberOfEnrolledInCourse) {
        this.numberOfEnrolledInCourse = numberOfEnrolledInCourse;
    }

    public void addToTotalEnrolledInCourse(Course c, Integer i) {
        totalEnrolledInCourses.put(c, i);
    }

    public HashMap<Course, Integer> getTotalEnrolledInCourses() {
        return totalEnrolledInCourses;
    }

    public void addCourseScores(Student student, double score) {
        courseScores.put(student, score);
    }

    public HashMap<Student, Double> getCourseScores() {
        return courseScores;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(String courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public double getScores() {
        return scores;
    }

    public void setScores(double scores) {
        this.scores = scores;
    }
}
