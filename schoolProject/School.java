/**
 * Title: CST 338 Project 1
 * Abstract: A program that includes four classes Course, Instructor, School and Student.
 * Three testclasses are used for testing.
 * Author: Håkon Karlsen
 * Date: 03-16-2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class School {

    private String schoolName;

    // Various hashmaps and arraylists
    private HashMap<String, String> takenEmails = new HashMap<>();
    private HashMap<String, String> instructorsAssignedToCourses = new HashMap<>();

    private ArrayList<String> takenEmployeeNumbers = new ArrayList<>();
    private ArrayList<String> takenStudentIDs = new ArrayList<>();

    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void readData(String s) {
        File f = new File(s);
        String[] array;

        int numberOfFollowingLines = 0;
        String nextData = "";
        String instructorEmployeeNumber;
        String instructorName;
        String instructorMailAddress;
        String instructorPhoneNumber;

        String courseNumber;
        String courseTitle;
        String courseCapacity;
        String classLocation;

        String studentID;
        String studentName;

        try {
            Scanner scan = new Scanner(f);
            // Reading text files
            while (scan.hasNextLine()) {
                String nextLine = scan.nextLine();
                array = nextLine.split(",");
                if (array.length > 1 && nextData.equals("")) {
                    instructorEmployeeNumber = array[0];
                    instructorName = array[1];
                    instructorMailAddress = array[2];
                    instructorPhoneNumber = array[3];
                    if (takenEmployeeNumbers.contains(instructorEmployeeNumber)) {
                        System.out.println("Instructor info reading failed - Employee number " +
                                instructorEmployeeNumber + " already used.");
                    } else {
                        takenEmployeeNumbers.add(instructorEmployeeNumber);
                        instructors.add(new Instructor(instructorEmployeeNumber, instructorName, instructorMailAddress, instructorPhoneNumber));
                        takenEmails.put(instructorMailAddress, instructorName);
                    }
                    numberOfFollowingLines -= 1;
                    if (numberOfFollowingLines == 0) {
                        nextData = "courses";
                    }
                } else if (array.length > 1 && nextData.equals("courses")) {
                    courseNumber = array[0];
                    courseTitle = array[1];
                    courseCapacity = array[2];
                    classLocation = array[3];
                    courses.add(new Course(courseNumber, courseTitle, courseCapacity, classLocation));
                    numberOfFollowingLines -= 1;
                    if (numberOfFollowingLines == 0) {
                        nextData = "students";
                    }
                } else if (array.length > 1 && nextData.equals("students")) {
                    studentID = array[0];
                    studentName = array[1];

                    if (takenStudentIDs.contains(studentID)) {
                        System.out.println("Student info reading failed - Student ID " +
                                studentID + " already used.");
                    } else {
                        takenStudentIDs.add(studentID);
                        students.add(new Student(studentID, studentName));
                    }
                    numberOfFollowingLines -= 1;
                    if (numberOfFollowingLines == 0) {
                        nextData = "end of text file";
                    }
                } else {
                    numberOfFollowingLines = Integer.parseInt(array[0]);
                }
            }
            System.out.println("Done.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found when reading file.");
            e.printStackTrace();
        }
    }

    public void schoolInfo() {
        String instructorNames = "";
        String courseNames = "";
        String studentNames = "";

        for (Instructor i : instructors) {
            instructorNames += i.getInstructorName() + "\n";
        }
        for (Course c : courses) {
            courseNames += c.getCourseTitle() + "\n";
        }
        for (Student s : students) {
            studentNames += s.getStudentName() + "\n";
        }
        System.out.println("School name: " + this.schoolName +
                "\nInstructor Information\n" + instructorNames +
                "\nCourse Information\n" + courseNames +
                "\nStudent Information\n" + studentNames);
    }

    public void searchByEmail(String Email) {
        System.out.println("Search key: " + Email);
        if (takenEmails.containsKey(Email)) {
            for (Instructor i : instructors) {
                if (i.getInstructorMailAddress().equals(Email)) {
                    System.out.println("Employee Number: " + i.getInstructorEmployeeNumber() +
                            "\nName: " + i.getInstructorName() + "\nPhone: " + i.getInstructorPhoneNumber());
                }
            }
        } else {
            System.out.println("No employee with email " + Email);
        }
    }

    public void addInstructor(int instructorEmployeeNumber, String instructorName, String instructorEmail,
                              String instructorPhoneNumber) {
        String instructorEmployeeNumberString = String.valueOf(instructorEmployeeNumber);
        instructors.add(new Instructor(instructorEmployeeNumberString, instructorName, instructorEmail,
                instructorPhoneNumber));
    }

    public void addCourse(int courseNumber, String courseTitle, int courseCapacity, String classLocation) {
        String courseNumberString = String.valueOf(courseNumber);
        String courseCapacityString = String.valueOf(courseCapacity);
        boolean courseNumberTaken = false;
        for (Course cou : courses) {
            if (cou.getCourseNumber().equals(courseNumberString)) {
                System.out.println("Course addition failed – Course number " + courseNumberString + " already used.");
                courseNumberTaken = true;
            }
        }
        if (!courseNumberTaken) {
            courses.add(new Course(courseNumberString, courseTitle, courseCapacityString, classLocation));
        }
    }

    public void assignInstructor(int courseNumber, int instructorEmployeeNumber) {
        String instructorEmployeeNumberString = String.valueOf(instructorEmployeeNumber);
        String courseTitleString = String.valueOf(courseNumber);
        if (takenEmployeeNumbers.contains(instructorEmployeeNumberString)) {
            instructorsAssignedToCourses.put(instructorEmployeeNumberString, courseTitleString);
        } else {
            System.out.println("Instructor " + instructorEmployeeNumber + " does not exist.");
        }
    }

    public void register(int courseNumber, int studentID) {
        String courseNumberString = String.valueOf(courseNumber);
        String studentIDString = String.valueOf(studentID);
        Course courseToRegisterTo = null;
        Student studentToRegister = null;
        if (takenStudentIDs.contains(studentIDString)) {
            for (Student stud : students) {
                if (stud.getStudentID().equals(studentIDString)) {
                    studentToRegister = stud;
                }
            }
            for (Course cours : courses) {
                if (cours.getCourseNumber().equals(courseNumberString)) {
                    courseToRegisterTo = cours;
                    int currentEnrolled = cours.getNumberOfEnrolledInCourse();
                    cours.setNumberOfEnrolledInCourse(currentEnrolled + 1);
                }
            }
            if (courseToRegisterTo != null) {
                studentToRegister.addToCoursesTaken(courseToRegisterTo);
            } else {
                System.out.println("Course " + courseNumberString + " not found.");
            }
        } else {
            System.out.println("Student " + studentIDString + " does not exist.");
        }
    }

    public void putScore(int courseNumber, int studentID, double score) {

        String studentIDString = String.valueOf(studentID);
        String courseNumberString = String.valueOf(courseNumber);

        for (Student stude : students) {
            if (stude.getStudentID().equals(studentIDString)) {
                for (Course cours : courses) {
                    if (cours.getCourseNumber().equals(courseNumberString)) {
                        if (stude.getCoursesTaken() != null) {
                            if (stude.getCoursesTaken().contains(cours)) {
                                cours.addCourseScores(stude, score);
                                cours.setScores(cours.getScores() + score);
                                System.out.println("scores: " + cours.getCourseScores().get(stude));
                            } else {
                                System.out.println("Student " + stude.getStudentID() + " (" + stude.getStudentName() +
                                        ")  is not enrolled in " + cours.getCourseNumber() + ".");
                            }
                        } else {
                            System.out.println("There is no such course.");
                        }
                    }
                }
            }
        }
    }

    public void unRegister(int courseNumber, int studentID) {
        String courseNumberString = String.valueOf(courseNumber);
        String studentIDString = String.valueOf(studentID);
        Course courseToUnRegisterFrom = null;
        Student studentToUnRegister = null;

        if (takenStudentIDs.contains(studentIDString)) {
            for (Student stud : students) {
                if (stud.getStudentID().equals(studentIDString)) {
                    studentToUnRegister = stud;
                }
            }
            for (Course cours : courses) {
                if (cours.getCourseNumber().equals(courseNumberString)) {
                    courseToUnRegisterFrom = cours;
                }
            }
            if (studentToUnRegister != null) {
                if (courseToUnRegisterFrom.getCourseNumber().equals(courseToUnRegisterFrom.getCourseNumber())) {
                    studentToUnRegister.getCoursesTaken().remove(courseToUnRegisterFrom);
                    for (int c = 0; c < studentToUnRegister.getCoursesTaken().size(); c++) {
                        System.out.println(studentToUnRegister.getCoursesTaken().get(c).getCourseNumber());
                    }
                }
            }
        } else {
            System.out.println("No such student ID found");
        }
    }

    public void courseInfo(int courseNumber) {
        String courseNumberString = String.valueOf(courseNumber);
        Course course = null;
        String instructor = null;
        double courseAverage = 0.00;

        for (Course c : courses) {
            if (c.getCourseNumber().equals(courseNumberString)) {
                course = c;
            }
        }
        for (Map.Entry<String, String> entry : instructorsAssignedToCourses.entrySet()) {
            if (entry.getValue().equals(courseNumberString)) {
                instructor = entry.getKey();
            }
        }
        for (Instructor i : instructors) {
            if (i.getInstructorEmployeeNumber().equals(instructor)) {
                instructor = i.getInstructorName();
            }
        }
        if (course != null) {
            courseAverage = Math.round(course.getScores() / course.getCourseScores().size());
        }

        if (course != null) {
            System.out.println("Course Number: " + course.getCourseNumber() + "\nInstructor: " +
                    instructor + "\nCourse Title: " + course.getCourseTitle() + "\nRoom: " + course.getClassLocation() +
                    "\nTotal enrolled: " + course.getNumberOfEnrolledInCourse() + "\nCourse Average: " +
                    courseAverage);
        }
    }

    public void deleteCourse(int courseNumber) {
        String courseNumberString = String.valueOf(courseNumber);
        Course courseToRemove = null;
        for (Course c : courses
        ) {
            if (c.getCourseNumber().equals(courseNumberString)) {
                if (c.getNumberOfEnrolledInCourse() == 0) {
                    System.out.println("removing " + c.getCourseTitle());
                    courseToRemove = c;
                } else {
                    System.out.println("Cannot delete courses with students in");
                }
            }
        }
        courses.remove(courseToRemove);
    }

    public void addStudent(int i, String studentName) {
    }

    public Course getCourse(int courseNumber) {
        String courseNumberString = String.valueOf(courseNumber);

        for (Course course : courses) {
            if (course.getCourseNumber().equals(courseNumberString)) {
                return course;
            }
        }
        System.out.println("No such course");
        return null;
    }

    public Instructor getInstructor(int i) {
        return null;
    }

    public Student getStudent(int i) {
        return null;
    }

    public void graduateStudent(int i) {
    }

    public void courseInfo() {
        String print = "Number of Courses: ";
        int numberOfCourses = courses.size();
        System.out.println(print + numberOfCourses);
        for (Course u : courses) {
            System.out.println(u.getCourseNumber() + ": " + u.getNumberOfEnrolledInCourse() + " enrolled");
        }
    }
}
// out of time