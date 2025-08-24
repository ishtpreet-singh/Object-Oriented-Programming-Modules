import java.util.Scanner;
public class M1_3Task_4 { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score;

        while (true) { 
            score = 0;

            
            for (int i = 1; i <= 10; i++) {
                int num1 = (int) (Math.random() * 10) + 1;
                int num2 = (int) (Math.random() * 10) + 1; 

                System.out.printf("Problem %d: %d * %d = ",i,num1,num2);
                int answer = input.nextInt();

                if (answer == num1 * num2) {
                    System.out.printf("Correct!\n");
                    score=score+1;
                } else {
                    System.out.printf("Incorrect. The correct answer is %d \n",(num1 * num2));
                }
            }

            System.out.printf("You scored %d out of 10.",score);

            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication tables!");
                break;
            } else {
                System.out.println("Let's try a new set of problems.\n");
            }
        }
    }
}

