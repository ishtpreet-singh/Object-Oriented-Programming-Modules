import java.util.Random;

class SumThread extends Thread {
    int[] arr;
    int start, end;
    long sum = 0;

    public SumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
    }
}

public class SimpleParallelSum {
    public static void main(String[] args) throws InterruptedException {
        int size = 100000;
        int[] numbers = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(100); 
        }


        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores = " + cores);
         
        int chunk = size / cores;
        SumThread[] threads = new SumThread[cores];
        for (int i = 0; i < cores; i++) {
            int start = i * chunk;
            int end = (i == cores - 1) ? size : start + chunk;
            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
        }
        long totalSum = 0;
        for (int i = 0; i < cores; i++) {
        threads[i].join(); //doubt
        totalSum += threads[i].sum;
}
System.out.println("Total Sum = " + totalSum);
    }

}
