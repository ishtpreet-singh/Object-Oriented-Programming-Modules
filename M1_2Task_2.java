
import java.util.Scanner;

public class M1_2Task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ther first side of Triangle:");
        double first = input.nextFloat();
        System.out.print("Enter ther second side of Triangle:");
        double second = input.nextFloat();
        double hyp;
        hyp=(Math.pow(first,2)+Math.pow(second, 2));
        hyp=Math.sqrt(hyp);
        System.out.printf("The hypotenuse of the triangle is: %f",hyp);


    }
}
