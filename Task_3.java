import java.util.Scanner;
public class Task_3{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        int product;
        product=first*second*third;
       
        float avg;
        float x=3;
        avg=(first+second+third)/x;

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.printf("The Product of the numbers is %d\n",product);
        System.out.printf("The Average of the numbers is %f",avg);
    }
}