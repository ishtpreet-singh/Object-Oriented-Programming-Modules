import java.util.Scanner;

public class M1_2Task_1 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter temperature in Fahrenheit:");
    float temp = input.nextFloat();
    float celsius = (temp - 32) * 5 / 9;
    System.out.printf("The Temprature in celsius is %.1f", celsius);
}
}
