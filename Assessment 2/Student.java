
/**
 * Write a description of class Student here.
 *
 * @author JashanPreet Kaur
 * @version (a version number or a date)
 */
class Student {
    private String lastName;
    private String firstName;
    private String studentID;
    private String a1;
    private String a2;
    private String a3;

    public Student(String lastName, String firstName, String studentID, String a1, String a2, String a3) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        
        // Correctly check the parameters passed to the constructor
        if (a1 == null || a1.isEmpty() || a1.equals("N/A"))
            this.a1 = "0";
        else 
            this.a1 = a1;
            
        if (a2 == null || a2.isEmpty() || a2.equals("N/A"))
            this.a2 = "0";
        else 
            this.a2 = a2;
            
        if (a3 == null || a3.isEmpty() || a3.equals("N/A"))
            this.a3 = "0";
        else 
            this.a3 = a3;

    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }

    public String getA3() {
        return a3;
    }

    public double getTotalMarks() {
        return Double.parseDouble(a1) + Double.parseDouble(a2) + Double.parseDouble(a3);
    }
}
