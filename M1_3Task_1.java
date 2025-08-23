
import java.util.Scanner;

public class M1_3Task_1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the coefficient of x^2:");
        int a=input.nextInt();
        System.out.print("Enter the coefficient of x:");
        int b=input.nextInt();
        System.out.print("Enter the coefficient of constant:");
        int c=input.nextInt();
        double x=(Math.pow(b,2)-4*a*c);
        if (x>0){
            double root1,root2;
            root1=(-b+Math.sqrt(x))/2*a;
            root2=(-b-Math.sqrt(x))/2*a;
            System.out.printf("Roots are:%.2f,%.2f",root1,root2);}
        else if (x==0){
            double roots;
            roots=(-b/2*a);
            System.out.printf("Roots are %.2f,%.2f",roots,roots);
        }   
        else {
            System.out.printf("Not real Roots");
        } 
    }
}
