
import java.util.Random;
import java.util.Scanner;



public class M1_4Task_1 {
    public static void main(String[] args) {
        String[] first= {"jack","rohan","levi","john"};
        String[] last={"Singh","paul","sharma","garg"};
        Scanner input=new Scanner(System.in);
        System.out.print("Enter number of names to generate: ");
        int num = input.nextInt();

        System.out.printf("Number of Names: %d\n", num);

        Random rand=new Random();
        int i;
        for(i=0;i<num;i++){
            int firstIndex = rand.nextInt(first.length);
            int lastIndex = rand.nextInt(last.length);

    String fullName = first[firstIndex] + " " + last[lastIndex];
    System.out.println (fullName);
        }


    }
}
