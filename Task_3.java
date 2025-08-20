import java.util.Scanner; // Import Scanner class for input

public class Task_3 {
    
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the first number
        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine()); 
        // Read input as a string, then convert to int

        // Ask the user for the second number
        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        // Ask the user for the third number
        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        // Calculate the product of three numbers
        int product;
        product = first * second * third;

        // Calculate the average
        // Use float for correct decimal division
        float x = 3; 
        float avg;
        avg = (first + second + third) / x;

        // Print the sum of the numbers directly
        System.out.println("The sum of the numbers is " + (first + second + third));

        // Print the product using printf
        System.out.printf("The Product of the numbers is %d\n", product);

        // Print the average using printf
        System.out.printf("The Average of the numbers is %f", avg);
    }
}