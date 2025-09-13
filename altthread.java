class EvenThread extends Thread {
    int max;
    public EvenThread(int max){
        this.max=max;}
        public void run(){
    for(int i=1;i<20;i++){
        if(i%2==0){
            System.out.println("Even Thread = "+i);
        }
    }
}
}
class OddThread extends Thread{
    int max;
    public OddThread(int max){
        this.max=max;
    }
    public void run(){
        for (int i=0;i<max;i++){
            if (i%2!=0){
                System.out.println("OddThread = "+i);
            }
        }
    }
}
public class altthread{
    public static void main(String[] args) {
        int max=20;
        Thread even=new EvenThread(max);
        Thread odd=new OddThread(max);
        even.start();
        odd.start();

    }
}
