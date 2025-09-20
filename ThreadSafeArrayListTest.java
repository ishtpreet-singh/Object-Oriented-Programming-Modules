import java.util.ArrayList;

class ThreadSafeList<T> {
    private ArrayList<T> list;

    public ThreadSafeList() {
        list = new ArrayList<>();
    }

    public synchronized void add(T element) {
        list.add(element);
        System.out.println(Thread.currentThread().getName() + " added: " + element);
    }

    public synchronized void remove(T element) {
        if (list.remove(element)) {
            System.out.println(Thread.currentThread().getName() + " removed: " + element);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to remove " + element + " but it was not found.");
        }
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized void printList() {
        System.out.println("Current List: " + list);
    }
}

class ListTestThread extends Thread {
    private ThreadSafeList<String> safeList;

    public ListTestThread(ThreadSafeList<String> safeList) {
        this.safeList = safeList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            safeList.add(Thread.currentThread().getName() + "-item" + i);
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }
        for (int i = 0; i < 2; i++) {
            safeList.remove(Thread.currentThread().getName() + "-item" + i);
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadSafeArrayListTest {
    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        Thread t1 = new ListTestThread(safeList);
        Thread t2 = new ListTestThread(safeList);
        Thread t3 = new ListTestThread(safeList);

        t1.setName("Thread1");
        t2.setName("Thread2");
        t3.setName("Thread3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        safeList.printList();
        System.out.println("Final size of list: " + safeList.size());
    }
}