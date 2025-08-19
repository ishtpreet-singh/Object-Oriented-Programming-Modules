import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.print("Enter your name: ");
        //String name = input.nextLine();
        int value = input.nextInt();
//        System.out.printf("Your name is %s", name);
        if (value<0){
            System.out.println("Is Negative.");

        }
        if (value>0){
            System.out.println("Is Positive.");
        }
    }
}