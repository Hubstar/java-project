public class Instructor {

    private String instructorEmployeeNumber;
    private String instructorName;
    private String instructorMailAddress;
    private String instructorPhoneNumber;

    public Instructor(String instructorEmployeeNumber, String instructorName, String instructorMailAddress, String instructorPhoneNumber) {
        this.instructorEmployeeNumber = instructorEmployeeNumber;
        this.instructorName = instructorName;
        this.instructorMailAddress = instructorMailAddress;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public String getInstructorEmployeeNumber() {
        return instructorEmployeeNumber;
    }

    public void setInstructorEmployeeNumber(String instructorEmployeeNumber) {
        this.instructorEmployeeNumber = instructorEmployeeNumber;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorMailAddress() {
        return instructorMailAddress;
    }

    public void setInstructorMailAddress(String instructorMailAddress) {
        this.instructorMailAddress = instructorMailAddress;
    }

    public String getInstructorPhoneNumber() {
        return instructorPhoneNumber;
    }

    public void setInstructorPhoneNumber(String instructorPhoneNumber) {
        this.instructorPhoneNumber = instructorPhoneNumber;
    }
}
