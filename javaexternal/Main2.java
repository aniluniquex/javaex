import java.io.*;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Get grades from user
        double[] grades = new double[8];
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }
        
        // Write grades to binary file
        DataOutputStream output = new DataOutputStream(new FileOutputStream("grades.txt"));
        for (double grade : grades) {
            output.writeDouble(grade);
        }
        output.close();
        
        // Read grades from binary file
        DataInputStream input = new DataInputStream(new FileInputStream("grades.txt"));
        double highestGrade = Double.MIN_VALUE;
        double lowestGrade = Double.MAX_VALUE;
        while (input.available() > 0) {
            double grade = input.readDouble();
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
        }
        input.close();
        
        // Output highest and lowest grades
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);
    }
}
