
import java.util.Scanner;

public class M1_3Task_3 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.printf("Enter starting digit:");
        int start=input.nextInt();
        System.out.printf("Enter last digit:");;
        int end=input.nextInt();
        int i,j;
        boolean isPrime;
        for(i=start;i<=end;i++){
            isPrime=true;
            if (i<=1){
                isPrime=false;
            }
            for (j=2;j<=i/2;j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if (isPrime){
                System.out.printf("%d ",i);
            }
        }
    }
}
