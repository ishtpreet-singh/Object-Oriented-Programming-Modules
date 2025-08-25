
import java.util.Scanner;

public class M1_4Task_2 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter number of elements in Array:");
        int x=input.nextInt();
        int[] arr=new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = input.nextInt();
        }
                for (int i = 0; i < x; i++) {
            System.out.printf("%d ",arr[i]);

    }
}Find the subarray with the maximum sum using the following logic:
Iterate through all possible subarrays in the array.
Calculate the sum of each subarray.
Keep track of the maximum sum found and the corresponding subarray indices.
