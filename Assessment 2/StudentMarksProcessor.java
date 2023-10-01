
/**
 * Write a description of class StudentMarks here.
 *
 * @author -Jashanpreet Kaur
 * @studentID -  
 */
import java.io.*;
import java.util.*;

public class StudentMarksProcessor {
    private static List<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sony\\OneDrive\\Desktop\\prog5001_students_grade_2022.txt"));
                String line;

        while ((line = br.readLine()) != null) {
            // Skip lines that are comments or empty lines
            if (line.startsWith("Unit") || line.startsWith("Last Name")|| line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\t");
            String lastName = parts[0];
            String firstName = parts[1];
            String studentID = parts[2];
            String a1 = parts.length > 3 ? parts[3] : "N/A";
            String a2 = parts.length > 4 ? parts[4] : "N/A";
            String a3 = parts.length > 5 ? parts[5] : "N/A";
            

            // Create a Student object and add it to the list
            Student student = new Student(lastName, firstName, studentID, a1, a2, a3);
            students.add(student);
        }
        br.close();
    } catch (IOException e) {
        System.err.println("Error reading the file.");
    }
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Read and display student marks");
            System.out.println("2. Calculate total marks");
            System.out.println("3. Print students below a threshold");
            System.out.println("4. Print top 5 and bottom 5 students");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    readAndDisplayStudentMarks();
                    break;
                case 2:
                    calculateTotalMarks();
                    break;
                case 3:
                    System.out.println("Enter the threshold: ");
                    int threshold = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    printStudentsBelowThreshold(threshold);
                    break;
                case 4:
                    printTopAndBottomStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Function to read and display student marks
    public static void readAndDisplayStudentMarks() {
         for (Student student : students) {
 
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Student ID: " +student.getStudentID());
            System.out.println("A1: " + student.getA1());
            System.out.println("A2: " + student.getA2());
            System.out.println("A3: " + student.getA3());
            System.out.println();
        }
    
    }

    // Function to calculate total marks
    public static void calculateTotalMarks() {
        for (Student student : students) {
            double total = 0.0; // Initialize total to 0.0
    
            // Parse and sum A1, A2, and A3 only if they are valid numbers
            if (student.getA1().isEmpty()||student.getA1().equals("N/A"))
                total += 0;
            else 
                total += Double.parseDouble(student.getA1());
            
            if (student.getA2().isEmpty()||student.getA2().equals("N/A"))
                total += 0;
            else 
                total += Double.parseDouble(student.getA2());
            
            if (student.getA3().isEmpty()||student.getA3().equals("N/A"))
                total += 0;
            else 
                total += Double.parseDouble(student.getA3());
            
            System.out.print("Student ID: " + student.getStudentID()+"  ");
            System.out.println("Total Marks: " + total);
            System.out.println();
        }
    }
    
    

    // Function to print students below a threshold
    public static void printStudentsBelowThreshold(int threshold) {
       for (Student student : students) {
            double total = Double.valueOf(student.getA1()) + Double.valueOf(student.getA2()) + Double.valueOf(student.getA3());
            if (total < threshold) {
                System.out.println("Last Name: " + student.getLastName());
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Total Marks: " + total);
                System.out.println();
            }
        }
    }

    // Function to print top 5 and bottom 5 students
    public static void printTopAndBottomStudents() {
        students.sort(Comparator.comparingDouble(Student::getTotalMarks).reversed()); // Sort in descending order
        int size = students.size();
        int topCount = Math.min(5, size);
        int bottomCount = Math.min(5, size);

        System.out.println("Top 5 Students:");
        for (int i = 0; i < topCount; i++) {
            Student student = students.get(i);
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Total Marks: " + student.getTotalMarks());
        }

        System.out.println("\nBottom 5 Students:");
        for (int i = size - 1; i >= size - bottomCount; i--) {
            Student student = students.get(i);
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Total Marks: " + student.getTotalMarks());
        }
    }
    }

    
